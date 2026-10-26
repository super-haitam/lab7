package problem2;

import java.util.*;

class CategoryNode {
    Category category;
    int totalPoint;
    CategoryNode(Category category, int totalPoint){
        this.category = category;
        this.totalPoint = totalPoint;
    }
}

class EmployeeNode {
    IEmployee employee;
    int totalPoint;
    EmployeeNode(IEmployee employee, int totalPoint){
        this.employee = employee;
        this.totalPoint = totalPoint;
    }
}

enum Category {
    InformationTechnologies,
    HumanResources,
    Accounting,
    Sales,
    Marketing,
    Legal
}

interface IHelpDesk {
    public void addTicket(ITicket ticket);
    public void addEmployee(IEmployee employee);
    public void completeTicket(String employeeFullName, int ticketId);
    public int getWaitingTicketCount();
    public int getCompletedTicketsTotalPoint();
    public List <CategoryNode> getTicketsTotalPointByCategory();
    public List <EmployeeNode> getTicketsTotalPointByEmployee();
}