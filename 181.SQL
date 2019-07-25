Select E1.Name as Employee
From Employee as E1, Employee as E2
Where E1.ManagerId = E2.Id and E1.Salary>E2.Salary;
