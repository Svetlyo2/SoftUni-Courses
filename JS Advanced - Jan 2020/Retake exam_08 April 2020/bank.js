
class Bank {
    #bankName;

    constructor(bankName) {
        this.#bankName = bankName;
        this.allCustomers = [];
    }


    newCustomer (customer){
        let targetCustomer=this.allCustomers.filter(c=>c['personalId']===customer['personalId'])[0];
        if (targetCustomer){
            throw new Error(`${customer.firstName} ${customer.lastName} is already our customer!`)
        } else {
            this.allCustomers.push(customer);
            return customer;
        }
    }

    depositMoney (personalId, amount){
        let targetCustomer=this.allCustomers.filter(c=>c['personalId']===personalId)[0];
        if (!targetCustomer){
            throw new Error('We have no customer with this ID!');
        } else {
            if (!targetCustomer.hasOwnProperty('totalMoney')){
                targetCustomer['totalMoney']=0;
            }
            targetCustomer['totalMoney']+=Number(amount);
            if (!targetCustomer.hasOwnProperty('transactions')){
                targetCustomer['transactions']=[];
            }
            let transaction={type:'deposit',amount};
            targetCustomer['transactions'].push(transaction);
            return`${targetCustomer.totalMoney}$`
        }

    }
    withdrawMoney (personalId, amount){
        let targetCustomer=this.allCustomers.filter(c=>c['personalId']===personalId)[0];
        if (!targetCustomer){
            throw new Error('We have no customer with this ID!');
        }
        if (!targetCustomer.hasOwnProperty('totalMoney')){
            targetCustomer['totalMoney']=0;
        }
        if (targetCustomer.totalMoney<amount){
            throw new Error(`${targetCustomer.firstName} ${targetCustomer.lastName} does not have enough money to withdraw that amount!`)
        }
        targetCustomer.totalMoney-=amount;
        let transaction={type:'withdraw',amount};
        targetCustomer.transactions.push(transaction);
        return`${targetCustomer.totalMoney}$`
    }
    customerInfo (personalId){
        let c=this.allCustomers.filter(c=>c['personalId']===personalId)[0];
        if (!c){
            throw new Error('We have no customer with this ID!');
        }
        let output=`Bank name: ${this.#bankName}`;
        output+=`\nCustomer name: ${c.firstName} ${c.lastName}`;
        output+=`\nCustomer ID: ${c.personalId}`;
        output+=`\nTotal Money: ${c.totalMoney}$\nTransactions:`;
        for (let i = c.transactions.length-1; i >=0 ; i--) {
            if (c.transactions[i].type==='deposit'){
                output+=`\n${i+1}. ${c.firstName} ${c.lastName} made deposit of ${c.transactions[i].amount}$!`
            } else {
                output+=`\n${i+1}. ${c.firstName} ${c.lastName} withdrew ${c.transactions[i].amount}$!`
            }
        }
        return output;
    }
}

let bank = new Bank('SoftUni Bank');

console.log(bank.newCustomer({firstName: 'Svetlin', lastName: 'Nakov', personalId: 6233267}));
console.log(bank.newCustomer({firstName: 'Mihaela', lastName: 'Mileva', personalId: 4151596}));
bank.depositMoney(6233267, 250);
console.log(bank.depositMoney(6233267, 250));
bank.depositMoney(4151596,555);
console.log(bank.withdrawMoney(6233267, 125));

console.log(bank.customerInfo(6233267));

