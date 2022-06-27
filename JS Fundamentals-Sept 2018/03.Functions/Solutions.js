
// 1. Inside Volume
function solve(arr) {
    let x1=10, x2=50;
    let y1=20,y2=80;
    let z1=15,z2=50;
    for (let i = 0; i < arr.length; i+=3) {
        let x=arr[i];
        let y=arr[i+1];
        let z=arr[i+2];
        if (x1<=x && x<=x2 && y1<=y && y<=y2 && z1<=z && z<=z2) {
            console.log('inside');
        } else {console.log('outside')}
    }
}
// solve([13.1, 50, 31.5,
//     50, 80, 50,
//     -5, 18, 43]);

// 2. Road Radar
function solve([speed,area]) {
    let speedDiff=speed-getLimit(area);
    if (speedDiff>40) console.log('reckless driving');
    else if (speedDiff>20) console.log('excessive speeding');
    else if (speedDiff>0) console.log('speeding');

    function getLimit(area) {
        switch (area) {
            case 'city':return 50;
            case 'residential':return 20;
            case 'interstate':return 90;
            case 'motorway':return 130;
            default: return 'error';
        }
    }
}
// solve([130, 'motorway']);

// 3. Template Format
function solve(arr) {
    let xml='<?xml version="1.0" encoding="UTF-8"?>\n' +
        '<quiz>\n';
    for (let i = 0; i < arr.length; i+=2) {
        xml+=`  <question>\n    ${arr[i]}\n  </question>\n  <answer>\n    ${arr[i+1]}\n  </answer>\n`;
    }
    xml+='</quiz>';
    console.log(xml);
}
// solve(["Dry ice is a frozen form of which gas?",
//     "Carbon Dioxide",
//     "What is the brightest star in the night sky?",
//     "Sirius"]);

// 4. Cooking by Numbers
function solve(arr) {
    let result=arr[0];
    for (let i = 1; i < arr.length; i++) {
        let operation=arr[i];
        switch (operation) {
            case 'chop': result/=2;
                console.log(result);
                break;
            case 'dice': result=Math.sqrt(result);console.log(result); break;
            case 'spice': result+=1;console.log(result); break;
            case 'bake': result*=3;console.log(result); break;
            case 'fillet': result*=0.8;console.log(result); break;
        }
    }
}
// solve(['9', 'dice', 'spice', 'chop', 'bake', 'fillet']);

// 5. Modify Average
function solve(n) {
    let numberAsString=''+n;
    let average=0;
    while (average<=5){
        average=0;
        let sum=0;
        for (const digit of numberAsString) {
            sum+=digit*1;
        }
        average=sum/numberAsString.length;
        if (average<=5) numberAsString+='9';
    }
    console.log(numberAsString);
}
// solve(5835);

// 6. Validity Checker
function solve([x1, y1, x2, y2]) {
    let dist1=Math.sqrt(x1**2+y1**2);
    let dist2=Math.sqrt(x2**2+y2**2);
    let dist=Math.sqrt((x1-x2)**2+(y1-y2)**2);
    dist1===parseInt(dist1)? console.log(`{${x1}, ${y1}} to {0, 0} is valid`):console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);
    dist2===parseInt(dist2)? console.log(`{${x2}, ${y2}} to {0, 0} is valid`):console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);
    dist===parseInt(dist)? console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`):console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
}
// solve([2, 1, 1, 1]);

// 7. Treasure Locator
function solve(arr) {
    for (let i = 0; i < arr.length; i+=2) {
        let x=arr[i];
        let y=arr[i+1];
        if (1<=x && x<=3 && 1<=y && y<=3){
            console.log('Tuvalu')
        } else if (8<=x && x<=9 && 0<=y && y<=1){
            console.log('Tokelau')
        } else if (0<=x && x<=2 && 6<=y && y<=8){
            console.log('Tonga')
        } else if (5<=x && x<=7 && 3<=y && y<=6){
            console.log('Samoa')
        } else if (4<=x && x<=9 && 7<=y && y<=8){
            console.log('Cook')
        } else console.log('On the bottom of the ocean');
    }
}
// solve([6, 4]);

// 8. Trip Length
function solve([x1, y1, x2, y2, x3, y3]) {
    function calcDistance(a1,a2,b1,b2){
        let distX=Math.abs((b1-a1)**2);
        let distY=Math.abs((b2-a2)**2);
        return Math.sqrt(distX+distY);
    }
    let dist12=calcDistance(x1,y1,x2,y2);
    let dist13=calcDistance(x1,y1,x3,y3);
    let dist23=calcDistance(x2,y2,x3,y3);
    let dist123=dist12+dist23;
    let dist132=dist13+dist23;
    let dist213=dist12+dist13;
    if (dist123<=dist132 && dist123<=dist213) console.log(`1->2->3: ${dist123}`);
    else if (dist213<=dist123 && dist213<=dist132) console.log(`2->1->3: ${dist213}`);
    else if (dist132<=dist123 && dist132<=dist213) console.log(`1->3->2: ${dist132}`);
}
solve([-1, -2, 3.5, 0, 0, 2]);