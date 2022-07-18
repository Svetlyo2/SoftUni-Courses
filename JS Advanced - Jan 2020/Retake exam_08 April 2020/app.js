function solve() {
    const taskInput=document.getElementById("task");
    const descriptionInput=document.getElementById("description");
    const dateInput=document.getElementById("date");
    const addBtn=document.getElementById("add");
    const openDiv=document.querySelector("body > main > div > section:nth-child(2) > div:nth-child(2)");
    const progresDiv=document.getElementById('in-progress');
    const completeDiv=document.querySelector("body > main > div > section:nth-child(4) > div:nth-child(2)");

    addBtn.addEventListener('click', function (e) {
        e.preventDefault();
        let task=taskInput.value;
        let description=descriptionInput.value;
        let date=dateInput.value;
        if (!task && !description && !date) return;
        let article=newElement('article');
        let h3=newElement('h3',task);
        let p1=newElement('p',`Description: ${description}`);
        let p2=newElement('p',`Due Date: ${date}`);
        let div=newElement('div','',['flex']);
        let button1=newElement('button','Start',['green']);
        button1.addEventListener('click', function () {
            let selectedArt=this.parentNode.parentNode;
            console.log('this:'+this);
            this.textContent='Delete';
            this.classList.replace('green','red');
            let finishBtn=this.nextElementSibling;
            finishBtn.classList.replace('red','orange');
            finishBtn.textContent='Finish';
            progresDiv.appendChild(selectedArt);
            this.addEventListener('click',function () {
                selectedArt.remove();
            });
            finishBtn.addEventListener('click',function () {
                // finishBtn.parentNode.parentNode.lastElementChild.innerHTML = '';
                let b=finishBtn.parentNode;
                b.remove();
                completeDiv.appendChild(selectedArt);
            })

        });
        let button2=newElement('button','Delete',['red']);
        button2.addEventListener('click', function (){
            console.log('del clicked');
            openDiv.removeChild(openDiv.firstElementChild);
        })
        div.appendChild(button1);
        div.appendChild(button2);
        article.appendChild(h3);
        article.appendChild(p1);
        article.appendChild(p2);
        article.appendChild(div);
        openDiv.appendChild(article);
    });

    function newElement(type, text, classes, id) {
        let element = document.createElement(type);
        if (text) {
            element.innerHTML = text;
        }
        if (classes) {
            element.classList.add(...classes);
        }
        if (id) {
            element.id = id;
        }
        return element;
    }
}
