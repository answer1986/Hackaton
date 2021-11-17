package Metodo_Lectura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;




// metodo para  conectar a la base de datos

class DBhepler {
    /*String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://127.0.0.1;DatabaseName=javenforexcel";*/

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/javenforexcel";


    Connection con = null;
    ResultSet res = null;

    public void DataBase() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println ("No se pudo cargar el controlador JDBC / ODBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println ("No se puede conectar a la base de datos");
            e.printStackTrace();
        }
    }

    // Consultar
    public ResultSet  Search(String sql, String str[]) {
        DataBase();
        try {
            PreparedStatement pst =con.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            res = pst.executeQuery();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    // agregar, eliminar y modificar
    public int AddU(String sql, String str[]) {
        int a = 0;
        DataBase();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            a = pst.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return a;
    }

}



// Las entidades de la tabla son las siguientes

class StuEntity {
    private int id;
    private String name;
    private String sex;
    private int num;



    public StuEntity() {
    }
    public StuEntity(int id, String name, String sex, int num) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.num = num;
    }

    @Override
    public String toString() {
        return "StuEntity [id=" + id + ", name=" + name + ", sex=" + sex
                + ", num=" + num + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }


}

 // Java implementa la clase principal de datos de importación de Excel Leer todos los datos y datos de operación en la tabla de Excel (consulta, actualización)

public class StuService {
    /**
     * Consultar todos los datos en la tabla stu
     * @return
     */
    public static List<StuEntity> getAllByDb(){
        List<StuEntity> list=new ArrayList<StuEntity>();
        try {
            DBhepler db=new DBhepler();
            String sql="select * from stu";
            ResultSet rs= db.Search(sql, null);
            while (rs.next()) {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String sex=rs.getString("sex");
                int num=rs.getInt("num");

                //System.out.println(id+" "+name+" "+sex+ " "+num);
                list.add(new StuEntity(id, name, sex, num));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Consultar todos los datos en la hoja de cálculo en el directorio especificado
      //@param archivo ruta completa del archivo
     * @return






     Al siguiente metodo se le debe asignar la hoja

     */

    public static List<StuEntity> getAllByExcel(String file){
        List<StuEntity> list=new ArrayList<StuEntity>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
 //           Hoja rs = rwb.getSheet ("Prueba Shee 1"); // o rwb.getSheet (0)
            int clos = rs.getColumns (); // Obtiene todas las columnas
            int filas = rs.getRows (); // Obtener todas las filas

          System.out.println(clos+" rows:"+ rows);
             for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    // El primero es el número de columnas, el segundo es el número de filas
                    String id = ((Sheet) rs).getCell (j ++, i) .getContents (); // El número más a la izquierda también se cuenta como una columna por defecto, así que aquí está j ++
                    String name=rs.getCell(j++, i).getContents();
                    String sex=rs.getCell(j++, i).getContents();
                    String num=rs.getCell(j++, i).getContents();

                    System.out.println("id:"+id+" name:"+name+" sex:"+sex+" num:"+num);
                    list.add(new StuEntity(Integer.parseInt(id), name, sex, Integer.parseInt(num)));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

 /**
 * Determinar si existe por Id.
 * @param id
 * @return
 */
    public static boolean isExist(int id){
        try {
            DBhepler db=new DBhepler();
            ResultSet rs=db.Search("select * from stu where id=?", new String[]{id+""});
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        List<StuEntity> all=getAllByDb();
        for (StuEntity stuEntity : all) {
            System.out.println(stuEntity.toString());
        }

        System.out.println(isExist(1));

    }

}

// Importar datos a una hoja de Excel


class TestDbToExcel {

    public static void main(String[] args) {
        try {
            WritableWorkbook wwb = null;

            // Cree un libro de trabajo de Excel modificable
            String fileName = "D://book.xls";
            File file=new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            // Cree un libro de trabajo con fileName como nombre de archivo
            wwb = Workbook.createWorkbook(file);

            // Crear hoja de trabajo
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

            // Consulta todos los datos en la base de datos
            List<StuEntity> list= StuService.getAllByDb();
            // El número de fila de la tabla de Excel que se insertará, comenzando desde 0 por defecto
            Label labelId = new Label (0, 0, "Number (id)"); // Indica el primero
            Label labelName = new Label (1, 0, "Nombre (nombre)");
            Label labelSex = new Label (2, 0, "Sexo (sexo)");
            Label labelNum = new Label (3, 0, "Salario (num)");

            ws.addCell(labelId);
            ws.addCell(labelName);
            ws.addCell(labelSex);
            ws.addCell(labelNum);
            for (int i = 0; i < list.size(); i++) {

                Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
                Label labelName_i= new Label(1, i+1, list.get(i).getName());
                Label labelSex_i= new Label(2, i+1, list.get(i).getSex());
                Label labelNum_i= new Label(3, i+1, list.get(i).getNum()+"");
                ws.addCell(labelId_i);
                ws.addCell(labelName_i);
                ws.addCell(labelSex_i);
                ws.addCell(labelNum_i);
            }

            // Escribe en el documento
            wwb.write();
            // Cerrar el objeto del libro de Excel
            wwb.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

//  Importe los datos de la tabla de Excel a la base de datos MySql

class TestExcelToDb {
    public static void main(String[] args) {
        // Obtener todos los datos de la tabla
        List<StuEntity> listExcel=StuService.getAllByExcel("d://book.xls");
       // Obtener todos los datos de la tabla de la base de datos
        List<StuEntity> listDb=StuService.getAllByDb();

        DBhepler db=new DBhepler();

        for (StuEntity stuEntity : listExcel) {
            int id=stuEntity.getId();
            if (!StuService.isExist(id)) {
                // Agregar si no existe
                String sql="insert into stu (name,sex,num) values(?,?,?)";
                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+""};
                db.AddU(sql, str);
            }else {
                // Actualizar si existe
                String sql="update stu set name=?,sex=?,num=? where id=?";
                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+"",id+""};
                db.AddU(sql, str);
            }
        }
    }
}
