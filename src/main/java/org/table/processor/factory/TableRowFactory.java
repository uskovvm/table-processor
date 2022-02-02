package org.table.processor.factory;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;
import org.table.processor.model.TableRow;

@Component
public class TableRowFactory {

	public TableRow build(Row row) {
		TableRow tableRow = new TableRow();
		String companyTitle = row.getCell(1).getStringCellValue();
		tableRow.setTitle(companyTitle);
		tableRow.setFactQliqData1(row.getCell(2).getNumericCellValue());
		tableRow.setFactQliqData2(row.getCell(3).getNumericCellValue());
		tableRow.setFactQoilData1(row.getCell(4).getNumericCellValue());
		tableRow.setFactQoilData2(row.getCell(5).getNumericCellValue());
		tableRow.setForecastQliqData1(row.getCell(6).getNumericCellValue());
		tableRow.setForecastQliqData2(row.getCell(7).getNumericCellValue());
		tableRow.setForecastQoilData1(row.getCell(8).getNumericCellValue());
		tableRow.setForecastQoilData2(row.getCell(9).getNumericCellValue());
		tableRow.setDate(row.getCell(10).getDateCellValue());
		return tableRow;
	}
}
