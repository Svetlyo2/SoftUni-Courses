function attachEvents() {
    const messages=document.getElementById('messages');
    const authorInput=document.getElementById('author');
    const contentInput=document.getElementById('content');
    const sendBtn=document.getElementById('submit');
    const refreshBtn=document.getElementById('refresh');
    const url='https://rest-messanger.firebaseio.com/messanger';

    sendBtn.addEventListener('click', send);
    refreshBtn.addEventListener('click',refresh);

    function refresh() {
        messages.value='';
        fetch(url+'.json')
            .then(checkForErrors)
            .then(res=>res.json())
            .then(checkForErrors)
            .then(d=>append(d))
            .catch(handleError)
    }
    function append(d) {
        Object.keys(d).forEach(k=>{
            let {author,content}=d[k];
            messages.value+=`${author}: ${content}\n`;
        })
    }

    function send() {
        let author=authorInput.value;
        let content=contentInput.value;
        let fetchOptions={
            method:'POST',
            headers: {'Content-type':'text'},
            body:JSON.stringify({author,content})
        };
        fetch(url+'.json',fetchOptions)
            .then(()=>{
                authorInput.value='';
                contentInput.value='';
            })
            .catch(handleError)
    }
    function handleError(err) {
        console.error(err);
    }
    function checkForErrors(res) {
        if (res === null || res === undefined) {
            throw new Error('Invalid JSON data!');
        }
        else if (res.ok === false) {
            throw new Error(`${res.status} - ${res.statusText}`);
        }
        return res;
    }
}

attachEvents();