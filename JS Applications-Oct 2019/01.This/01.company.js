//1.	Company

class Company {

    constructor() {
        this.departments = [];
    }
    addEmployee(username, salary, position, department){
        function isValid(param) {
            return !(param === '' || param === undefined || param === null);

        }
        if (!isValid(username) || !isValid(salary)||!isValid(position)||!isValid(department) || salary<0){
            throw new Error("Invalid input!")
        }
        let obj=this.departments.find(o=>o.name===department);
        if (obj===undefined){
            obj={
                name:department,
                employees:[],
                averageSalary: function () {
                    return this.employees
                        .reduce((totalSalaries,e)=>totalSalaries+e.salary,0)/this.employees.length;
                }
            };
        this.departments.push(obj);
        }
        obj.employees.push({username, salary, position});
        return `New employee is hired. Name: ${username}. Position: ${position}`;
    }
    bestDepartment(){
        let bestDept=this.departments.sort((a,b)=>b.averageSalary()-a.averageSalary())[0];
        let output=`Best Department is: ${bestDept.name}\nAverage salary: ${bestDept.averageSalary().toFixed(2)}\n`;
        output+=bestDept.employees
            .sort((a,b)=>b.salary-a.salary||a.username.localeCompare(b.username))
            // .forEach(e=>output+=`\n${e.name} ${e.salary} ${e.position}`);
            .map(e=>`${e.username} ${e.salary} ${e.position}`).join('\n');
        return output;
    }
}

let c = new Company();
// console.log(c.addEmployee("Stanimir", 2000, "engineer", "Construction"));
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());
