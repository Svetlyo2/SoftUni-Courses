
const username='guest';
const password='guest';
const appKey='kid_Hy-203wCU';
const appSecret='6723f36961814d3da0e030437ed38d26';
const baseUrl = `https://baas.kinvey.com/appdata/${appKey}/books`;

function makeHeaders(method, data) {
    const headers = {
        method: method,
        headers: {
            'Authorization': `Basic ${btoa(`${username}:${password}`)}`,
            'Content-Type': 'application/json'
        }
    };
    if (method !== 'GET') {
        headers.body = JSON.stringify(data);
    }
    return headers;
}

async function get() {
    const headers = makeHeaders('GET');
    const data = await fetchRequest(baseUrl, headers);
    return data;
}
async function getBook(bookID) {
    const headers = makeHeaders('GET');
    const url = `${baseUrl}/${bookID}`;
    const data = await fetchRequest(url, headers);
    return data;
}
async function post(body) {
    const headers = makeHeaders('POST', body);
    const data = fetchRequest(baseUrl, headers);
    return data;
}
async function put(body, bookID) {
    const headers = makeHeaders('PUT', body);
    const url = `${baseUrl}/${bookID}`;
    return fetchRequest(url, headers);

}
async function del(bookID) {
    const headers = makeHeaders('DELETE');
    const url = `${baseUrl}/${bookID}`;
    return fetchRequest(url, headers);
}
async function fetchRequest(url, headers) {
    return fetch(url, headers)
        .then(checkForErrors)
        .then(data => data.json())
        .catch(console.error)
}
function checkForErrors(req) {
    if (!req.ok) {
        throw new Error(`${req.status} - ${req.statusText}`);
    }
    return req;
}
export { get,getBook, post, put, del }

// function makeHeaders(httpMethod,data) {
//     const headers={
//         method:httpMethod,
//         headers:{
//             'Authorization':`Basic ${btoa(`${username}:${password}`)}`,
//             'Content-type':'application/json',
//         }
//     };
//     console.log(headers.headers);
//     if(httpMethod!=='GET'){
//         headers.body=JSON.stringify(data);
//     }
// }
// export function createPromise(kinveyModul,endpoint,headers) {
//     const url=`${baseUrl}/${kinveyModul}/${appKey}/${endpoint}`;
//     return fetch(url,headers)
//         .then(handleError)
//         .then(serializeData)
// }
// export function get(kinveyModul,endpoint) {
//     const headers = makeHeaders('GET');
//     return createPromise(kinveyModul, endpoint, headers)
// }
// export function post(kinveyModul,endpoint,data) {
//     const headers=makeHeaders('POST',data);
//     return createPromise(kinveyModul,endpoint,headers)
// }
// export function put(kinveyModul,endpoint,data) {
//     const headers=makeHeaders('PUT',data);
//     return createPromise(kinveyModul,endpoint,headers)
// }
// export function del(kinveyModul,endpoint) {
//     const headers=makeHeaders('DELETE');
//     return createPromise(kinveyModul,endpoint,headers)
// }
function handleError(e) {
    if (!e.ok) throw new Error(e.statusText);
    return e;
}
function serializeData(x) {
    return x.json();
}