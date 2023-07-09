package managerAndRepotees;

import java.util.HashMap;
import java.util.Map;

public class ManagerAndEmployees {

	public static void main(String[] args) {

		System.out.println(getManagerReportees().toString());

	}

	private static Map<Character, Integer> getManagerReportees() {

		Character selfReportee = null;
		Map<Character, Integer> managerToReporteeMap = new HashMap<Character, Integer>();

		for (Map.Entry<Character, Character> entry : getEmployeeToManagerMapping().entrySet()) {

			Character employee = entry.getKey();
			Character manager = entry.getValue();

			if (employee == manager) {
				selfReportee = employee;
			}

			if (!managerToReporteeMap.containsKey(employee)) {
				managerToReporteeMap.put(employee, 0);
			}

			if (managerToReporteeMap.containsKey(manager)) {
				managerToReporteeMap.put(manager, managerToReporteeMap.get(manager) + 1);
			}
		}

		managerToReporteeMap.put(selfReportee, managerToReporteeMap.get(selfReportee) - 1);

		for (Map.Entry<Character, Character> entry : getEmployeeToManagerMapping().entrySet()) {

			Character employee = entry.getKey();
			Character manager = entry.getValue();

			if (employee != manager && managerToReporteeMap.containsKey(manager)) {
				managerToReporteeMap.put(manager, managerToReporteeMap.get(manager) + managerToReporteeMap.get(employee));
			}
		}

		return managerToReporteeMap;
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
