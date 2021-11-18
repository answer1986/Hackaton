package Metodo_Lectura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

// metodo para  conectar a la base de datos
class DBhepler {
    /*String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://127.0.0.1;DatabaseName=javenforexcel";*/

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/hacka";

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
    public ResultSet Search(String sql, String str[]) {
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
    private String carrier;
    private String tamano;
    private String deliveryType;
    private String serviceType;
    private String customerDestination;
    private Date creationDate;
    private Date promiseDate;
    private List<NodeEntity> nodeEntities;

    public StuEntity(String carrier, String tamano, String deliveryType, String serviceType, String customerDestination, Date creationDate, Date promiseDate) {
        this.carrier = carrier;
        this.tamano = tamano;
        this.deliveryType = deliveryType;
        this.serviceType = serviceType;
        this.customerDestination = customerDestination;
        this.creationDate = creationDate;
        this.promiseDate = promiseDate;
    }

    public StuEntity(int id, String carrier, String tamano, String deliveryType, String serviceType, String customerDestination, Date creationDate, Date promiseDate) {
        this.id = id;
        this.carrier = carrier;
        this.tamano = tamano;
        this.deliveryType = deliveryType;
        this.serviceType = serviceType;
        this.customerDestination = customerDestination;
        this.creationDate = creationDate;
        this.promiseDate = promiseDate;
    }

    public StuEntity(int id, String carrier, String tamano, String deliveryType, String serviceType,
                     String customerDestination, Date creationDate, Date promiseDate, List<NodeEntity> nodeEntities) {
        this.id = id;
        this.carrier = carrier;
        this.tamano = tamano;
        this.deliveryType = deliveryType;
        this.serviceType = serviceType;
        this.customerDestination = customerDestination;
        this.creationDate = creationDate;
        this.promiseDate = promiseDate;
        this.nodeEntities = nodeEntities;
    }

    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }

    public String getTamano() { return tamano; }
    public void setTamano(String tamano) { this.tamano = tamano; }

    public String getDeliveryType() { return deliveryType; }
    public void setDeliveryType(String deliveryType) { this.deliveryType = deliveryType; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getCustomerDestination() { return customerDestination; }
    public void setCustomerDestination(String customerDestination) { this.customerDestination = customerDestination; }

    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public Date getPromiseDate() { return promiseDate; }
    public void setPromiseDate(Date promiseDate) { this.promiseDate = promiseDate; }

    public List<NodeEntity> getNodeEntities() { return nodeEntities; }
    public void setNodeEntities(List<NodeEntity> nodeEntities) { this.nodeEntities = nodeEntities; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "StuEntity{" +
                "id=" + id +
                ", carrier='" + carrier + '\'' +
                ", tamano='" + tamano + '\'' +
                ", deliveryDate='" + deliveryType + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", customerDestination='" + customerDestination + '\'' +
                ", creationDate=" + creationDate +
                ", promiseDate=" + promiseDate +
                ", nodeEntities=" + nodeEntities +
                '}';
    }
}

class NodeEntity {
    private int idStu;
    private String idNode;
    private String typeNode;
    private String opTypeNode; // OperatorTypeNode
    private Date estArrivalNode; // EstimatedArrivalNode
    private String nodeArrival;
    private Date estDispatchNode; // EstimatedDispatchNode
    private String nodeDispatch;

    public NodeEntity(int idStu, String idNode, String typeNode, String opTypeNode, Date estArrivalNode,
                      String nodeArrival, Date estDispatchNode, String nodeDispatch) {
        this.idStu = idStu;
        this.idNode = idNode;
        this.typeNode = typeNode;
        this.opTypeNode = opTypeNode;
        this.estArrivalNode = estArrivalNode;
        this.nodeArrival = nodeArrival;
        this.estDispatchNode = estDispatchNode;
        this.nodeDispatch = nodeDispatch;
    }

    public int getIdStu() { return idStu; }
    public void setIdStu(int idStu) { this.idStu = idStu; }

    public String getIdNode() { return idNode; }
    public void setIdNode(String idNode) { this.idNode = idNode; }

    public String getTypeNode() { return typeNode; }
    public void setTypeNode(String typeNode) { this.typeNode = typeNode; }

    public String getOpTypeNode() { return opTypeNode; }
    public void setOpTypeNode(String opTypeNode) { this.opTypeNode = opTypeNode; }

    public Date getEstArrivalNode() { return estArrivalNode; }
    public void setEstArrivalNode(Date estArrivalNode) { this.estArrivalNode = estArrivalNode; }

    public String getNodeArrival() { return nodeArrival; }
    public void setNodeArrival(String nodeArrival) { this.nodeArrival = nodeArrival; }

    public Date getEstDispatchNode() { return estDispatchNode; }
    public void setEstDispatchNode(Date estDispatchNode) { this.estDispatchNode = estDispatchNode; }

    public String getNodeDispatch() { return nodeDispatch; }
    public void setNodeDispatch(String nodeDispatch) { this.nodeDispatch = nodeDispatch; }

    @Override
    public String toString() {
        return "NodeEntity{" +
                "idNode='" + idNode + '\'' +
                ", typeNode='" + typeNode + '\'' +
                ", opTypeNode='" + opTypeNode + '\'' +
                ", estArrivalNode=" + estArrivalNode +
                ", nodeArrival='" + nodeArrival + '\'' +
                ", estDispatchNode=" + estDispatchNode +
                ", nodeDispatch='" + nodeDispatch + '\'' +
                '}';
    }

}

 // Java implementa la clase principal de datos de importación de Excel Leer todos los datos y datos de operación en la tabla de Excel (consulta, actualización)
 class StuService {
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
                int id = rs.getInt("id");
                String carrier = rs.getString("carrier");
                String tamano = rs.getString("tamano");
                String deliveryType = rs.getString("delivery_type");
                String serviceType = rs.getString("service_type");
                String customerDestination = rs.getString("customer_destination");
                Date creationDate = rs.getDate("creation_date");
                Date promiseDate = rs.getDate("promise_date");

                //System.out.println(id+" "+name+" "+sex+ " "+num);
                list.add(new StuEntity(id, carrier, tamano, deliveryType, serviceType, customerDestination,
                        creationDate, promiseDate));
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
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet ("Sheet1"); // o rwb.getSheet (0)
            int clos = rs.getColumns (); // Obtiene todas las columnas
            int rows = rs.getRows (); // Obtener todas las filas

          System.out.println(clos+" rows:"+ rows);
             for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    // El primero es el número de columnas, el segundo es el número de filas
                    String carrier = ((Sheet) rs).getCell (j ++, i) .getContents (); // El número más a la izquierda también se cuenta como una columna por defecto, así que aquí está j ++
                    String tamano = rs.getCell(j++, i).getContents();
                    String deliveryType = rs.getCell(j++, i).getContents();
                    String serviceType = rs.getCell(j++, i).getContents();
                    String customerDestination = rs.getCell(j++, i).getContents();
                    String creationDate = rs.getCell(j++, i).getContents();
                    String promiseDate = rs.getCell(j++, i).getContents();

                    SimpleDateFormat dt = new SimpleDateFormat("dd-mm-yyyy");

                    System.out.println("carrier:"+carrier+" tamano:"+tamano+" deliveryType:"+deliveryType+" serviceType:"+serviceType
                    +" customerDestination:"+customerDestination+" creationDate:"+creationDate+" promiseDate:"+promiseDate);
                    list.add(new StuEntity(carrier, tamano, deliveryType, serviceType, customerDestination, dt.parse(creationDate),
                            dt.parse(promiseDate)));
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

//  Importe los datos de la tabla de Excel a la base de datos MySql
class TestExcelToDb {
    public void main(String[] args) {
        // Obtener todos los datos de la tabla
        List<StuEntity> listExcel = StuService.getAllByExcel("/Users/blindcl/Documents/Hackaton/Hackaton/Example_Data_v2.xlsx");
        // Obtener todos los datos de la tabla de la base de datos
        List<StuEntity> listDb = StuService.getAllByDb();

        DBhepler db = new DBhepler();

        for (StuEntity stuEntity : listExcel) {
            int id = stuEntity.getId();
            if (!StuService.isExist(id)) {
                // Agregar si no existe
                String sql = "insert into stu (name,sex,num) values(?,?,?)";
                String[] str = new String[]{stuEntity.getCarrier(), stuEntity.getTamano(), stuEntity.getDeliveryType(),
                        stuEntity.getServiceType(), stuEntity.getCustomerDestination(), stuEntity.getCreationDate().toString(),
                        stuEntity.getPromiseDate() + ""};
                db.AddU(sql, str);
            } else {
                // Actualizar si existe
                String sql = "update stu set name=?,sex=?,num=? where id=?";
                String[] str = new String[]{stuEntity.getCarrier(), stuEntity.getTamano(), stuEntity.getDeliveryType(),
                        stuEntity.getServiceType(), stuEntity.getCustomerDestination(), stuEntity.getCreationDate().toString(),
                        stuEntity.getPromiseDate() + "", id + ""};
                db.AddU(sql, str);
            }
        }
    }
}}