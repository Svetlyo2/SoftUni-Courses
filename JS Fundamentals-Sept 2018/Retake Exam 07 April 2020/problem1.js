function solve(arr) {
    let seats=arr.splice(0,1)[0];
    let sectors=['A','B','C'];
    let litex=new Set();
    let levski=new Set();
    let vip=new Set();
    for (const sector of sectors) {
        for (let i = 1; i <= seats; i++) {
            litex.add(i+sector);
            levski.add(i+sector);
            vip.add(i+sector);
        }
    }
    let amount=0;
    let fans=0;
    for (const line of arr) {
        let [team,seat,sector]=line.split('*');
        let targetSeat=seat+sector;
        if (team==='VIP'){
            if (vip.has(targetSeat)){
                vip.delete(targetSeat);
                fans++;
                amount+=getPrice(team,sector);
            } else printUnavailable(team,seat,sector);

        } else if (team==='LEVSKI'){
            if (levski.has(targetSeat)){
                levski.delete(targetSeat);
                fans++;
                amount+=getPrice(team,sector);
            } else printUnavailable(team,seat,sector);
        } else{
            if (litex.has(targetSeat)){
                litex.delete(targetSeat);
                fans++;
                amount+=getPrice(team,sector);
            } else printUnavailable(team,seat,sector);
        }
    }
    console.log(`${amount} lv.
${fans} fans`);

    function printUnavailable(t,s,sect) {
        console.log(`Seat ${s} in zone ${t} sector ${sect} is unavailable`)
    }
    function getPrice(t,s){
        let price=0;
        if (t==='VIP'){
            switch (s) {
                case 'A':price=25;break;
                case 'B':price=15;break;
                case 'C':price=10;break;
                default: break;
            }
        } else {
            switch (s) {
                case 'A':price=10;break;
                case 'B':price=7;break;
                case 'C':price=5;break;
                default: break;
            }
        }
        return price;
    }
}

solve(["5",
    "LITEX*5*A", "LITEX*5*B", "LITEX*5*A", "VIP*1*A"]
);