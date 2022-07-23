function attachEvents() {
    const phonebookUl=document.getElementById('phonebook');
    const loadBtn=document.getElementById('btnLoad');
    const createBtn=document.getElementById('btnCreate');
    const url='https://phonebook-nakov.firebaseio.com/phonebook';
    // const url='https://phonebook-1118.firebaseio.com/phonebook'; //my db
    const personInput=document.getElementById('person');
    const phoneInput=document.getElementById('phone');

    loadBtn.addEventListener('click', load);
    createBtn.addEventListener('click',create);
    function create() {
        let person=personInput.value;
        let phone=phoneInput.value;
        let fetchOptions={
            method:'POST',
            headers: {'Content-type':'application/json'},
            body:JSON.stringify({person,phone})
        };
        fetch(url+'.json',fetchOptions)
            .then(()=>{
                personInput.value='';
                phoneInput.value='';
                phonebookUl.innerHTML='';
                load();
            })
            .catch(displayError);
    }
    function load() {
        fetch(url+'.json')
            .then(res=> res.json())
            .then(d=>append(d))
            .catch(displayError)
    }
    function append(d) {
        Object.keys(d).forEach(k=>{
            let {person,phone}=d[k];
            // let {name,phone}=d[k];
            let li=document.createElement('li');
            li.textContent=`${person}: ${phone}`;
            // li.textContent=`${name}: ${phone}`;
            // li.setAttribute('key',k);
            let deleteBtn=document.createElement('button');
            deleteBtn.textContent='Delete';
            deleteBtn.addEventListener('click', function () {
                let elem=this.parentNode;
                fetch(url+`/${k}.json`,{
                    method:'delete'
                })
                    .then(()=>{
                        phonebookUl.innerHTML='';
                        load();
                    })
            });
            li.appendChild(deleteBtn);
            phonebookUl.appendChild(li)
        });
    }

    function displayError() {
        let li=document.createElement('li');
        li.textContent='Error';
        phonebookUl.appendChild(li);
    }
}

attachEvents();