package org.table.processor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.table.processor.exceptions.IncorrectFileNameException;
import org.table.processor.factory.TableRowFactory;
import org.table.processor.model.TableRow;
import org.table.processor.model.TotalRow;
import org.table.processor.repository.TableRepository;

@Service
public class TableProcessor {
	private static Logger LOG = LoggerFactory.getLogger(TableProcessor.class);

	@Autowired
	private TableRowFactory factory;
	@Autowired
	private TableRepository repository;

	public void parseTable(String xlshFilePath) throws Exception {
		try (XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(xlshFilePath))) {
			Sheet sheet = wb.getSheet("Лист1");
			for (int i = 3; i <= sheet.getLastRowNum(); i++) {
				Row currentRow = sheet.getRow(i);
				TableRow tableRow = repository.save(factory.build(currentRow));
				LOG.info("Saved id: {}, title: {}"
						+ ", Fact qliq data1: {}, Fact qliq data2: {}"
						+ ", Fact qoil data1: {}, Fact qoil data2: {}"
						+ ", Forecast qliq data1: {}, Forecast qliq data2: {}"
						+ ", Forecast qoil data1: {}, Forecast qoil data2: {}"
						+ ", date: {}"
						, tableRow.getId(), tableRow.getTitle()
						, tableRow.getFactQliqData1(), tableRow.getFactQliqData2()
						, tableRow.getFactQoilData1(), tableRow.getFactQoilData2()
						, tableRow.getForecastQliqData1(), tableRow.getForecastQliqData2()
						, tableRow.getForecastQoilData1(), tableRow.getForecastQoilData2()
						, tableRow.getDate());
			}
		} catch (FileNotFoundException e) {
			throw new IncorrectFileNameException("File not found exception : " + xlshFilePath , e);
		} catch (IOException e) {
			throw new IncorrectFileNameException("File input stream exception : " + xlshFilePath , e);
		}
	}

	public List<TotalRow> getTotal() {
		return repository.calculateTotal();
	}
}
