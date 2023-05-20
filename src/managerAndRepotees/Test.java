package managerAndRepotees;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		System.out.println(getManagerReportees().toString());

	}

	private static Map<Character, Integer> getManagerReportees() {

		Map<Character, Integer> employeeToReporteesMap = new HashMap<>();
		char selfReportee = 0;

		for (Map.Entry<Character, Character> map : getEmployeeToManagerMapping().entrySet()) {

			char employee = map.getKey();
			char manager = map.getValue();

			if (employee == manager) {
				selfReportee = employee;
			}

			if (!employeeToReporteesMap.containsKey(employee)) {
				employeeToReporteesMap.put(employee, 0);
			}

			if (employeeToReporteesMap.containsKey(manager)) {
				employeeToReporteesMap.put(manager, employeeToReporteesMap.get(manager) + 1);
			}

		}
		employeeToReporteesMap.put(selfReportee, employeeToReporteesMap.get(selfReportee) - 1);
		
		for (Map.Entry<Character, Character> map : getEmployeeToManagerMapping().entrySet()) {

			char employee = map.getKey();
			char manager = map.getValue();

			if (employee != manager && employeeToReporteesMap.containsKey(manager)) {
				employeeToReporteesMap.put(manager, employeeToReporteesMap.get(manager) + employeeToReporteesMap.get(employee));
			}

		}
		
		return employeeToReporteesMap;
	}

	private static Map<Character, Character> getEmployeeToManagerMapping() {

		Map<Character, Character> employeeToManagerMappings = new HashMap<>();
		employeeToManagerMappings.put('P', 'P');
		employeeToManagerMappings.put('Q', 'P');
		employeeToManagerMappings.put('R', 'P');
		employeeToManagerMappings.put('S', 'Q');
		employeeToManagerMappings.put('T', 'Q');
		employeeToManagerMappings.put('U', 'R');
		return employeeToManagerMappings;
	}

}
