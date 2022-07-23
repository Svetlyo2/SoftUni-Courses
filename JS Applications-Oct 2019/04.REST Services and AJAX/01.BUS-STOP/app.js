function getInfo() {
    let stopId=document.getElementById('stopId').value;
    const stopName=document.getElementById('stopName');
    const ulBuses=document.getElementById('buses');
    let url=`https://judgetests.firebaseio.com/businfo/${stopId}.json `;
    stopName.innerHTML='';
    ulBuses.innerHTML='';
    let a=fetch(url)
        .then(res=> res.json())
        .then(x=>{
            const {buses, name}=x;
            stopName.textContent=name;
            Object.keys(buses).forEach(k=>{
                let li=document.createElement('li');
                        li.textContent=`Bus ${k} arrives in ${buses[k]}`;
                        ulBuses.appendChild(li);
            });
        })
        .catch(()=>{
        stopName.textContent='Error';
    })
}