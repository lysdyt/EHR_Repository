package com.babifood.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.babifood.dao.InitAttendanceDao;
import com.babifood.entity.InitAttendanceEntity;

@Repository
public class InitAttendanceDaoImpl implements InitAttendanceDao {

	Logger log = LoggerFactory.getLogger(InitAttendanceDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int queryAttendanceCountAttendance(String pNumber, String year, String month) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT Count(*) FROM ehr_init_attendance where `P_NUMBER` = ? and `YEAR` = ? and `MONTH` = ?");
		int count = 0;
		try {
			count = jdbcTemplate.queryForInt(sql.toString(), pNumber, year, month);
		} catch (Exception e) {
			log.error("操作数据库失败", e.getMessage());
		}
		return count;
	}

	@Override
	public void addInitAttendance(List<InitAttendanceEntity> attendanceList) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `ehr`.`ehr_init_attendance` (`YEAR`, `MONTH`, `P_NUMBER`, `P_NAME`, `COMPANY_CODE`, ");
		sql.append("`ORGANIZATION_CODE`, `DEPT_CODE`, `OFFICE_CODE`, `GROUP_CODE`, `POST`, `PUNCH_TYPE`, `ARRANGEMENT_TYPE`, ");
		sql.append("`DATE`, `WEEK_DAY`, `NORMAL_START_TIME`, `NORMAL_END_TIME`, `NORMAL_TIME`, `PUNCH_START_TIME`, `PUNCH_END_TIME`, ");
		sql.append("`ORIGINAL_TIME`, `WORK_TIME`, `LATE`, `LEAVE`, `COMPLETION`, `ABSENCE_HOURS`, `VACATION_HOURS`, `YEAR_VACATION`, ");
		sql.append("`RELAXATION`, `THING_VACATION`, `SICK_VACATION`, `TRAIN_VACATION`, `PARENTAL_VACATION`, `MARRIAGE_VACATION`, ");
		sql.append("`COMPANION_PARENTAL_VACATION`, `FUNERAL_VACATION`, `UNUSUAL_HOURS`, `OVERTIME_HOURS`, `TRAVEL_HOURS`, `MEAL_SUPPLEMENT`) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		List<Object[]> attend = new ArrayList<>();
		for (InitAttendanceEntity entity : attendanceList) {
			attend.add(new Object[] { entity.getYear(), entity.getMonth(), entity.getpNumber(), entity.getpName(),
					entity.getCompanyCode(), entity.getOrganizationCode(), entity.getDeptCode(), entity.getOfficeCode(),
					entity.getGroupCode(), entity.getPost(), entity.getPunchType(), entity.getArrangementType(),
					entity.getDate(), entity.getWeekDay(), entity.getNormalStartTime(), entity.getNormalEndTime(),
					entity.getNormalTime(), entity.getPunchStartTime(), entity.getPunchEndTime(),
					entity.getOriginalTime(), entity.getWorkTime(), entity.getLate(), entity.getLeave(),
					entity.getCompletion(), entity.getAbsenceHours(), entity.getVacationHours(),
					entity.getYearVacation(), entity.getRelaxation(), entity.getThingVacation(),
					entity.getSickVacation(), entity.getTrainVacation(), entity.getParentalVacation(),
					entity.getMarriageVacation(), entity.getCompanionParentalVacation(), entity.getFuneralVacation(),
					entity.getUnusualHours(), entity.getOvertimeHours(), entity.getTravelHours(),
					entity.getMealSupplement() });
		}
		try {
			jdbcTemplate.batchUpdate(sql.toString(), attend);
		} catch (Exception e) {
			log.error("员工 初始化排班失败,pNumber:" + attendanceList.get(0).getpNumber() + ",pName:"
					+ attendanceList.get(0).getpName(), e.getMessage());
		}
	}

}
