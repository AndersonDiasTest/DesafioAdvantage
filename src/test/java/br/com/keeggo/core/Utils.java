package br.com.keeggo.core;

import static br.com.keeggo.core.DriverFactory.getDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.Scenario;

public class Utils {

	public XSSFRow recuperaLinha (int indexLinha) throws IOException {
		File file = new File("src/test/resources/arquivos/CadastroUsuario.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row1 = sheet.getRow(indexLinha);
		wb.close();
		return row1;
	}
	
	public int recuperaIdColuna(String colunaBusca) throws IOException {
		XSSFRow row1 = recuperaLinha(0);
		int idColuna = 0;
		for (Iterator<Cell> iterator = row1.cellIterator(); iterator.hasNext();) {
			Cell celula = (Cell) iterator.next();
			if (celula.getStringCellValue().equals(colunaBusca)) {
				idColuna = celula.getColumnIndex();
			}
		}
		return idColuna;
	}
	
	public XSSFCell recuperaCelula (String colunaBusca) throws IOException {
		int idColuna = recuperaIdColuna(colunaBusca);
		XSSFRow row1 = recuperaLinha(1);
		XSSFCell celula = row1.getCell(idColuna);
		return celula;
	}
	
	public String recuperaCelulaString(String colunaBusca) throws IOException {
		XSSFCell celula = recuperaCelula(colunaBusca);
		return celula.getStringCellValue();
	}
	
	public boolean recuperaCelulaBoolean(String colunaBusca) throws IOException {
		XSSFCell celula = recuperaCelula(colunaBusca);
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
	public String recuperaCelulaNumerica(String colunaBusca) throws IOException {
		XSSFCell celula = recuperaCelula(colunaBusca);
		Double numDecimal = celula.getNumericCellValue();
		Integer inteiro = numDecimal.intValue();
		return inteiro.toString();
	}
	
	public void capturaTela(Scenario cenario) {
		final byte [] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
		cenario.attach(screenshot, "image/png", "image");
	}
	
}
