
// 1. Heroic Inventory
function solve(input) {
    let heroData=[];
    for (const line of input) {
        let arr=line.split(/\s*\/ \s*/gm);
        let name=arr[0];
        let level=Number(arr[1]);
        let items=[];
        if (arr.length>2)  items=arr[2].split(/\s*,\s*/);
        let hero={name,level,items};
        heroData.push(hero);
    }
    console.log(JSON.stringify(heroData));
}
// solve(['Isacc / 25 / Apple, GravityGun',
//     'Derek / 12 / BarrelVest, DestructionSword',
//     'Hes / 1 / Desolator, Sentinel, Antara']
// );

// 2. JSON's Table
function solve(arr) {
    let html='<table>\n';
    for (const line of arr) {
        let values=Object.values(JSON.parse(line));
        html+='\t<tr>\n';
        for (let value of values) {
            html+=`\t\t<td>${htmlEscape(value+'')}</td>\n`
        }
        html+='\t</tr>\n';
    }
    html+='</table>';
    console.log(html);

    function htmlEscape(str) {
        return str.replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    }
}
// solve(['{"name":"Pesho","position":"Promenliva","salary":100000}',
//     '{"name":"Teo","position":"Lecturer","salary":1000}',
//     '{"name":"Georgi","position":"Lecturer","salary":1000}']
// );

// 3. Cappy Juice
function solve(input) {
    let juices=new Map();
    let bottles=new Map();
    for (const line of input) {
        let arr=line.split(' => ');
        let juice=arr[0];
        let quantity=Number(arr[1]);
        if (!juices.has(juice)) juices.set(juice,0);
        juices.set(juice,juices.get(juice)+quantity);
        if (juices.get(juice)/1000>=1 && !bottles.has(juice)) bottles.set(juice,0);
    }
    for (let [j,q] of juices) {
        if (q/1000>=1) {
            bottles.set(j,Math.floor(q/1000));
        }
    }
    for (let [j,b] of bottles) {
        console.log(`${j} => ${bottles.get(j)}`)
    }
}
// solve(['Kiwi => 234',
//     'Pear => 2345',
//     'Watermelon => 3456',
//     'Kiwi => 4567',
//     'Pear => 5678',
//     'Watermelon => 6789']
// );

// 4. Store Catalogue
function solve(input) {
    let products={};
    for (const line of input) {
        let info=line.split(' : ');
        let product=info[0];
        products[product]=Number(info[1]);
    }
    let keys=Object.keys(products).sort((a,b)=>a.toLowerCase().localeCompare(b.toLowerCase()));
    for (let i = 0; i < keys.length; i++) {
        if (i===0) {console.log(keys[0].slice(0,1))}
        else if (keys[i].slice(0,1) !== keys[i-1].slice(0,1))
            console.log(keys[i].slice(0,1));
        console.log(`  ${keys[i]}: ${products[keys[i]]}`);
    }
}
// solve(['Appricot : 20.4',
//     'Fridge : 1500',
//     'TV : 1499',
//     'Deodorant : 10',
//     'Boiler : 300',
//     'Apple : 1.25',
//     'Anti-Bug Spray : 15',
//     'T-Shirt : 10']
// );

// 5. Auto-Engineering Company
function solve(input) {
    let cars=new Map();
    for (const line of input) {
        let [brand,model,units]=line.split(' | ');
        if (!cars.has(brand)) {
            cars.set(brand,new Map());
        }
        if (!cars.get(brand).has(model)) {cars.get(brand).set(model,0)}
        cars.get(brand).set(model,cars.get(brand).get(model)+Number(units));
    }
    for (const [b,p] of cars) {
        console.log(b);
        for (const [m,u] of p) {
            console.log(`###${m} -> ${u}`);
        }
    }
}
// solve(['Audi | Q7 | 1000',
//     'Audi | Q6 | 100',
//     'BMW | X5 | 1000',
//     'BMW | X6 | 100',
//     'Citroen | C4 | 123',
//     'Volga | GAZ-24 | 1000000',
//     'Lada | Niva | 1000000',
//     'Lada | Jigula | 1000000',
//     'Citroen | C4 | 22',
//     'Citroen | C5 | 10']
// );

// 6. System Components
function solve(input) {
    let systems=new Map();
    for (const line of input) {
        let [systemName,componentName,subcomponentName]=line.split(' | ');
        if (!systems.has(systemName)) systems.set(systemName,new Map());
        if (!systems.get(systemName).has(componentName)) systems.get(systemName).set(componentName,[]);
        systems.get(systemName).get(componentName).push(subcomponentName);
    }
    let systemsSorted=Array.from(systems.keys()).sort((s1,s2)=>sortSystems(s1,s2));
    for (const key of systemsSorted) {
        console.log(key);
        let sortedComponents=Array.from(systems.get(key).keys()).sort((c1,c2)=>sortComponents(key,c1,c2));
        for (const component of sortedComponents) {
            console.log('|||'+component);
            systems.get(key).get(component).forEach(s=>console.log('||||||'+s));
        }
    }

    function sortSystems(s1,s2){
        if (systems.get(s1).size!==systems.get(s2).size) return systems.get(s2).size-systems.get(s1).size;
        else return s1.toLowerCase().localeCompare(s2.toLowerCase());
    }
    function sortComponents(system,c1,c2){
        return systems.get(system).get(c2).length-systems.get(system).get(c1).length
    }
}
// solve(['SULS | Main Site | Home Page',
//     'SULS | Main Site | Login Page',
//     'SULS | Main Site | Register Page',
//     'SULS | Judge Site | Login Page',
//     'SULS | Judge Site | Submittion Page',
//     'Lambda | CoreA | A23',
//     'SULS | Digital Site | Login Page',
//     'Lambda | CoreB | B24',
//     'Lambda | CoreA | A24',
//     'Lambda | CoreA | A25',
//     'Lambda | CoreC | C4',
//     'Indice | Session | Default Storage',
//     'Indice | Session | Default Security']
// );

// 7. Usernames

function solve(arr) {
    let result=new Set();
    arr.filter(x=>x!=='').sort((a, b) => a.length-b.length ||a.localeCompare(b)).map(a=>result.add(a));
    result.forEach(n=>console.log(n));
}

// solve(['Denise',
//     'Ignatius',
//     'Iris',
//     'Isacc',
//     'Indie',
//     'Dean',
//     'Donatello',
//     'Enfuego',
//     'Benjamin',
//     'Biser',
//     'Bounty',
//     'Renard',
//     'Rot']
// );

// 8. Unique Sequences

function solve(input) {
    let arr=[];
    for (let i = 0; i < input.length; i++) {
        arr.push(JSON.parse(input[i]).sort((a,b)=>b-a));
    }
    arr.sort((a, b) => a.length - b.length);
    for (let i = 0; i < arr.length; i++) {
        for (let j = i+1; j < arr.length; j++) {
            if (areSameArrays(arr[i],arr[j])){
                arr.splice(j,1);
                j--;
            }
        }
    }
    arr.forEach(a=>console.log('['+a.join(', ')+']'));

    function areSameArrays(arr1, arr2) {
        if(arr1.length !== arr2.length) {
            return false;
        } else {
            for(let i=0; i<arr1.length; i++) {
                if(arr1[i] !== arr2[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
// solve(["[-3, -2, -1, 0, 1, 2, 3, 4]",
//     "[10, 1, -17, 0, 2, 13]",
//     "[4, -3, 3, -2, 2, -1, 1, 0]"]
// );