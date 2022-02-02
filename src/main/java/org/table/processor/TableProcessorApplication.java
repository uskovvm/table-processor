package org.table.processor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.table.processor.model.TotalRow;

@SpringBootApplication
public class TableProcessorApplication implements CommandLineRunner {
	private static Logger LOG = LoggerFactory.getLogger(TableProcessorApplication.class);

	@Autowired
	private TableProcessor processor;

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(TableProcessorApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {

		try {
			// Парсим таблицу exel, создаем таблицу в базе
			processor.parseTable(args[0]);
			// считаем total
			List<TotalRow> total = processor.getTotal();
			// выводим totals в лог
			total.stream().forEach(t -> LOG.info("Total: "
					+ "Fact qliq data1:{}, Fact qliq data2:{}, Fact qoil data1:{}, Fact qoil data2:{}, "
					+ "Forecast qliq data1:{}, Forecast qliq data2:{}, Forecast qoil data1:{}, Forecast qoil data2:{}, "
					+ "date: {}",
					Double.toString(t.getFactQliqData1()), Double.toString(t.getFactQliqData2()),
					Double.toString(t.getFactQoilData1()), Double.toString(t.getFactQoilData2()),
					Double.toString(t.getForecastQliqData1()), Double.toString(t.getForecastQliqData2()),
					Double.toString(t.getForecastQoilData1()), Double.toString(t.getForecastQoilData2()),
					t.getDate()));
		} catch (Exception e) {
			LOG.error("Table process exception: {}", e.getMessage());
		}
	}
}