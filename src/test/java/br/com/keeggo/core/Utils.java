package br.com.keeggo.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	public XSSFCell recuperaCelula (int indexCelula) throws IOException {
		File file = new File("src/test/resources/arquivos/CadastroUsuario.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row1 = sheet.getRow(1);
		XSSFCell celula = row1.getCell(indexCelula);
		wb.close();
		return celula;
	}
	
	public String recuperaCelulaString(int indexCelula) throws IOException {
		XSSFCell celula = recuperaCelula(indexCelula);
		return celula.getStringCellValue();
	}
	
	public boolean recuperaCelulaBoolean(int indexCelula) throws IOException {
		XSSFCell celula = recuperaCelula(indexCelula);
		boolean valor = false;
		switch (celula.getStringCellValue()) {
		case "true":
			valor = true;
			break;
		case "false":
			valor = false;
			break;
		}
		return valor;
	}
	public String recuperaCelulaNumerica(int indexCelula) throws IOException {
		XSSFCell celula = recuperaCelula(indexCelula);
		Double numDecimal = celula.getNumericCellValue();
		Integer inteiro = numDecimal.intValue();
		return inteiro.toString();
	}
	
}
