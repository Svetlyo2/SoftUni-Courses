function solve() {
    const infoContainer=document.getElementsByClassName('info')[0];
    const departBtn=document.getElementById('depart');
    const arriveBtn=document.getElementById('arrive');
    let currentId='depot';
    let stopName='';
    const url=`https://judgetests.firebaseio.com/schedule/`;


    function depart() {
        fetch(url+`${currentId}.json`)
            .then(res=> res.json())
            .then(d=>{
                let {name,next}=d;
                stopName=name;
                currentId=next;
                infoContainer.textContent=`Next stop ${name}`;
                departBtn.disabled = true;
                arriveBtn.disabled=false;

            })
        .catch(displayError)
    }
    function displayError() {
        infoContainer.textContent = 'Error';
        departBtn.disabled = true;
        arriveBtn.disabled = true;
    }

    function arrive() {
        departBtn.disabled = false;
        arriveBtn.disabled=true;
        infoContainer.textContent=`Arriving at ${stopName}`
    }

    return {
        depart,
        arrive
    };
}

let result = solve();