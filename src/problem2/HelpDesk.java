package problem2;

import java.util.ArrayList;
import java.util.List;

public class HelpDesk implements IHelpDesk {
    private List<IEmployee> employees = new ArrayList<>();
    private List<ITicket> tickets = new ArrayList<>();

    @Override
    public void addTicket(ITicket ticket) {
        tickets.add(ticket);
    }

    @Override
    public void addEmployee(IEmployee employee) {
        employees.add(employee);
    }

    @Override
    public void completeTicket(String employeeFullName, int ticketId) {
        // Find the ticket
        ITicket targetTicket = null;
        for (ITicket ticket : tickets) {
            if (ticket.getId() == ticketId) {
                targetTicket = ticket;
                break;
            }
        }
        if (targetTicket == null) return;

        // Find the employee
        IEmployee targetEmployee = null;
        for (IEmployee employee : employees) {
            if (employee.getFullName().equals(employeeFullName)) {
                targetEmployee = employee;
                break;
            }
        }
        if (targetEmployee == null) return;

        // Check if targetEmployee can complete targetTicket
        if (targetEmployee.getAssignedCategories().contains(targetTicket.getCategory()) &&
                targetEmployee.getPointLevel() >= targetTicket.getPoint() ) {

            targetTicket.setAssignedEmployee(targetEmployee.getFullName());
            targetTicket.setIsCompleted(true);
        }

    }

    @Override
    public int getWaitingTicketCount() {
        int count = 0;
        for (ITicket ticket : tickets) if (!ticket.getIsCompleted()) count ++;
        return count;
    }

    @Override
    public int getCompletedTicketsTotalPoint() {
        int totalPoints = 0;
        for (ITicket ticket : tickets) if (ticket.getIsCompleted()) totalPoints += ticket.getPoint();
        return totalPoints;
    }

    @Override
    public List<CategoryNode> getTicketsTotalPointByCategory() {
        List<CategoryNode> list = new ArrayList<>();

        for (Category category : Category.values()) {
            int totalPoints = 0;
            for (ITicket ticket : tickets) if (ticket.getCategory() == category) totalPoints += ticket.getPoint();

            list.add(new CategoryNode(category, totalPoints));
        }

        return list;
    }

    @Override
    public List<EmployeeNode> getTicketsTotalPointByEmployee() {
        List<EmployeeNode> list = new ArrayList<>();

        for (IEmployee employee : employees) {
            int totalPoints = 0;
            for (ITicket ticket : tickets) {
                if (ticket.getAssignedEmployee() != null && ticket.getAssignedEmployee().equals(employee.getFullName())) {
                    totalPoints += ticket.getPoint();
                }
            }

            list.add(new EmployeeNode(employee, totalPoints));
        }

        return list;
    }
}
