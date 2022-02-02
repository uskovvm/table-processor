package org.table.processor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.table.processor.model.TableRow;
import org.table.processor.model.TotalRow;

@Repository
public interface TableRepository extends JpaRepository<TableRow, Long> {

	@Query("SELECT new org.table.processor.model.TotalRow("
			+ " SUM(t.factQliqData1), SUM(t.factQliqData2), SUM(t.factQoilData1), SUM(t.factQoilData2),"
			+ " SUM(t.forecastQliqData1), SUM(t.forecastQliqData2), SUM(t.forecastQoilData1), SUM(t.forecastQoilData2),"
			+ " t.date)"
			+ " FROM TableRow AS t GROUP BY t.date ORDER BY t.date ASC")
	List<TotalRow> calculateTotal();
}
