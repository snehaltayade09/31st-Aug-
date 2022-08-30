package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrisation {
	public static String parameterisation(String sheet_name,int row,int cell) throws EncryptedDocumentException, IOException {
   FileInputStream file=new FileInputStream("D:\\projects\\workspace\\KiteZerodha1\\src\\test\\resources\\TextData.xlsx");
		String value=WorkbookFactory.create(file).getSheet(sheet_name).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
}

