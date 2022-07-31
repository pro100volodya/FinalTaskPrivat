# The final task of the Java course of Privatbank

### General requirements:

1. The user interface should be intuitive and give information on how the input should look like.
   (For example, date format, time format, etc.)
2. The user interface must allow the addition and presentation of all system information.
3. You must decide what the user interface will look like.
4. It is important to keep the principles of the OOP. You can use the tools that were learned in the
   course, including working with exceptions that will check the health of the data flow, defining a
   class hierarchy to avoid code duplication, interfaces, collections, generics, etc.
5. Input Validation:<br>
   5.1 The program must process all types of input and not crash due to an incorrect input type.<br>
   5.2 From the point of view of validating the length of values, the only restrictions are those
   that exist in the text of the task. There is no need to add restrictions that are not described
   in the document.

### Program description:

The company's management decided to try to optimize the work of the company by adjusting the working
conditions of its employees. According to their personal preference. In the initial state, all
employees in all departments and in all positions start the working day at 8:00 and end the working
day at 17:00 (there is one hour of lunch break). It can be assumed that there are 4 types of
preferences:

1. Start work earlier (and also finish the work day earlier)
2. Start working later (and also finish the work day later)
3. Remain in the working conditions that were before the experiment.
4. Work from home, without setting a specific start and end time, but also without changing the
   number of working hours.

The experiment will allow employees to start the work day earlier, later, not change working hours
or work from home, depending on their personal preferences and depending on their position
(if the position allows it).

##### It can be assumed, that:

+ Each work hour that corresponds to personal preferences increases the efficiency of the employee
  by 20% compared to the situation before the experiment.
+ Each working hour, contrary to personal preferences, reduces the employee's work efficiency by 20%
  compared to the situation before the experiment.
+ At the same time, if the employee does not change the hours of work, the efficiency of his work
  does not change.
+ If an employee is allowed to work from home and it suits their preference, that employee's
  efficiency will increase by 10% for every hour worked.

There are departments and positions that are not allowed to change hours of operation. There are
also departments that require the simultaneous work of all their employees, and therefore if you
decide to change (or not change) working hours, this obliges all employees of the department.

Instead of making the above changes to the action, the management will be able to use the simulator
program that we need to write.

The program will allow you to create departments, positions, employee preferences and present the
results of the experiment - what will be the profit / loss from this change in hours / employee.

For example, if 10 employees start their work day an hour later and this is in accordance with their
personal preferences, then exactly one hour of the work day they will work 20% more efficiently. The
total earnings of the company will be: 10 * 1 * 0,2 = 2

If we assume that the company earns an average of $10 per worker for every hour worked, then in this
case the increase in the company's daily income will be $20.

### Functional requirements:

Implement classes that describe the following entities:

+ company (Company) and it has several classes (Department)
+ class containing positions (Role)
+ position of the employee (Employee)
+ an employee is a person with preferences (Preference)
+ Preference is one of the working methods described above.

In addition, it is known that the company has three types of employees according to the method of
calculating their wages.

1. Employees on a basic salary. It can be assumed that there are 160 working hours in a month.
2. Workers with hourly wages.
3. Employees on base salary + percentage of monthly sales (a parameter that changes every month)

### UI Requirements

Support for the following is required:

1. Enter object data
2. Display object data
3. Decision to change the method of work on the job level
4. Decision to change the method of work at the department level
5. Presentation of profit or loss

