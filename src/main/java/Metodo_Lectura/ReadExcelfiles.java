package Metodo_Lectura;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelfiles
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("/Users/blindcl/Documents/Hackaton/Hackaton/Example_Data_v2.xlsx");   //llamando al archivo excel
            FileInputStream fis = new FileInputStream(file);   //obtengo los bits del archivo
        //creando una instancia de libro de trabajo que se refiere al archivo .xlsx
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //crear un objeto de hoja para recuperar el dato
            Iterator<Row> itr = sheet.iterator();    //iterando sobre el archivo de Excel
            while (itr.hasNext())
            {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterando sobre cada columna
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType())
                    {
                        case STRING:  //campo que representa el tipo de celda de cadena
                            System.out.print(cell.getStringCellValue() + "\t\t\t");
                            break;
                        case NUMERIC:    //campo que representa el tipo de numero de cadena
                            System.out.print(cell.getNumericCellValue() + "\t\t\t");
                            break;
                        default:
                    }
                }
                System.out.println("Archivo leido correctamente!!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}