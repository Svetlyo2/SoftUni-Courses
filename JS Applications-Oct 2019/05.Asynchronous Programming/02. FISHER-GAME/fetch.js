export function fetchData() {
    const url='https://fisher-game.firebaseio.com/catches/';
    const get=()=>{
        return fetch(`${url}.json`)
            .then(handleErrors)
            .then(res=>res.json());
    };
    const post=(body)=>{
        const fetchOptions={
            headers: {'Content-Type': 'application/json'},
            method: "POST",
            body: JSON.stringify(body)};
        return fetch(`${url}.json`,fetchOptions)
        .then(handleErrors)
        .then(res=>res.json());
    };
    const put=(body,id)=>{
        const fetchOptions={
            headers: {'Content-Type': 'application/json'},
            method: "PUT",
            body: JSON.stringify(body)};
        return fetch(`${url}${id}.json`,fetchOptions)
            .then(handleErrors)
            .then(res=>res.json());
    };
    const del=(id)=> {
        const fetchOptions = {method: "DELETE"};
        return fetch(`${url}${id}.json`, fetchOptions)
            .then(handleErrors);
    };
    function handleErrors(res) {
        if (!res.ok) throw new Error(`${res.status} - ${res.statusText}`);
        return res
    }

    return {get,post,put,del,handleErrors}
}
