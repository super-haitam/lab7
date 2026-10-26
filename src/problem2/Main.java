package problem2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HelpDesk helpDesk = new HelpDesk();

        // The first line contains an integer n, the number of employees.
        int N = scan.nextInt();


        // Each of the next n lines contains the employee information (FullName, PointLevel, AssignedCategories)
        scan.nextLine();
        for (int i = 0; i < N; ++i) {
            String s = scan.nextLine();

            String[] split = s.split(",");

            String fullName = split[0];
            int pointLevel = Integer.parseInt(split[1]);

            String[] categories = split[2].split(" ");
            List<Category> assignedCategories = new ArrayList<>();
            for (String categoryName : categories) {
                assignedCategories.add(Category.valueOf(categoryName));
            }

            helpDesk.addEmployee(new Employee(fullName, pointLevel, assignedCategories));
        }

        // The next line contains an integer m, the number of tickets
        int M = scan.nextInt();

        // Each of the next m lines contains the ticket information (Id, Name, Category, Point)
        scan.nextLine();
        for (int i = 0; i < M; ++i) {
            String s = scan.nextLine();

            String[] split = s.split(",");

            int id = Integer.parseInt(split[0]);
            String name = split[1];
            Category category = Category.valueOf(split[2]);
            int point = Integer.parseInt(split[3]);

            helpDesk.addTicket(new Ticket(id, name, category, point));
        }

        // The next line contains an integer k, the number of CompleteTicket calls.
        int K = scan.nextInt();

        // Each of the next k lines contains the process of ticket completion (Employee FullName, Ticket Id).
        scan.nextLine();
        for (int i = 0; i < K; ++i) {
            String s = scan.nextLine();

            String[] split = s.split(",");

            String employeeFullName = split[0];
            int ticketId = Integer.parseInt(split[1]);

            helpDesk.completeTicket(employeeFullName, ticketId);
        }

        // Output
        System.out.printf("WaitingTicketCount: %d\n", helpDesk.getWaitingTicketCount());
        System.out.printf("CompletedTicketsTotalPoints: %d\n", helpDesk.getCompletedTicketsTotalPoint());

        System.out.print("TicketsTotalPointByCategory: \n");
        List<CategoryNode> categoryNodes = helpDesk.getTicketsTotalPointByCategory();
        for (CategoryNode categoryNode : categoryNodes) {
            System.out.printf("\t%s: %d\n", categoryNode.category.name(), categoryNode.totalPoint);
        }

        System.out.print("TicketsTotalPointByEmployee: \n");
        List<EmployeeNode> employeeNodes = helpDesk.getTicketsTotalPointByEmployee();
        for (EmployeeNode employeeNode : employeeNodes) {
            System.out.printf("\t%s: %d\n", employeeNode.employee.getFullName(), employeeNode.totalPoint);
        }

    }
}























