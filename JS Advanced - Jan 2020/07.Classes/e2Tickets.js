function ticketsSorter(arr, criteria) {
    class Ticket{
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = +price;
            this.status = status;
        }
    }
    let tickets=[];
    arr.map(r=>{
        tickets.push(new Ticket(...r.split('|')));
    });
    return tickets.sort((t1,t2)=>{
        if (criteria==='price'){
            return t1[criteria]- t2[criteria];
    } else return t1[criteria].localeCompare(t2[criteria])
    })
}

console.log(ticketsSorter(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'status'
));