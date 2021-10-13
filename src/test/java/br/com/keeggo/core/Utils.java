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
	
	public void iteraSobreLinha(String colunaBusca) throws IOException {
		XSSFRow row1 = recuperaLinha(0);
		
		for (Iterator<Cell> iterator = row1.cellIterator(); iterator.hasNext();) {
			Cell celula = (Cell) iterator.next();
			System.out.println(celula.getStringCellValue());
			if (celula.getStringCellValue().equals(colunaBusca)) {
				int idColuna = celula.getColumnIndex();
				System.out.println(celula.getStringCellValue() + idColuna);
			}
		}
	}
	
	public XSSFCell recuperaCelula (int indexLinha, int indexCelula) throws IOException {
		XSSFRow row1 = recuperaLinha(indexLinha);
		XSSFCell celula = row1.getCell(indexCelula);
		return celula;
	}
	
	public String recuperaCelulaString(int indexCelula) throws IOException {
		XSSFCell celula = recuperaCelula(1, indexCelula);
		return celula.getStringCellValue();
	}
	
	public boolean recuperaCelulaBoolean(int indexCelula) throws IOException {
		XSSFCell celula = recuperaCelula(1, indexCelula);
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
		XSSFCell celula = recuperaCelula(1, indexCelula);
		Double numDecimal = celula.getNumericCellValue();
		Integer inteiro = numDecimal.intValue();
		return inteiro.toString();
	}
	
	public void capturaTela(Scenario cenario) {
		final byte [] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
		cenario.attach(screenshot, "image/png", "image");
	}
	
}
