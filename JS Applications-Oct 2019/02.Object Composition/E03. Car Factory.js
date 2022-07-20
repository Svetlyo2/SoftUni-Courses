function solve(o) {
    let engines=[{ power: 90, volume: 1800 },
    { power: 120, volume: 2400 },
    { power: 200, volume: 3500 }
];
    let engine=engines.filter(e=>e.power>=o.power)
        .sort((a,b)=>b-a)[0];
    let wheel=o.wheelsize%2!==0?o.wheelsize:o.wheelsize-1;
    return {
        model: o.model,
        engine:engine,
        carriage:{type:o.carriage,color:o.color},
        wheels:Array(4).fill(wheel)
    };
}

console.log(solve({ model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17 }

));