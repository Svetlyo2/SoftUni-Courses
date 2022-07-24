import {fetchData} from "./fetch.js";
import {getDomElements} from "./dom.js";

function attachEvents() {
    class Catch {
        constructor(angler, weight, species, location, bait, captureTime) {
            this.angler = angler;
            this.weight = weight;
            this.species = species;
            this.location = location;
            this.bait = bait;
            this.captureTime = captureTime;
        }
    }
    const buttonsFunctionality = {
        Add: () => createCatch(),
        Load: () => load(),
        Update: (btn) => updateCatch(btn),
        Delete: (btn) => deleteCatch(btn)
    };
    const template=getDomElements().$template();
    document.querySelector("body").addEventListener('click', function (e) {
        if (typeof buttonsFunctionality[e.target.textContent] === 'function') {
            buttonsFunctionality[e.target.textContent](e.target);
        }
    });

    function getInfo(div) {
        return Array.from(div.getElementsByTagName('input'))
            .map(i=>i.value)
    }
    function updateCatch(btn) {
        let id=btn.parentNode.getAttribute('data-id');
        let values=getInfo(btn.parentNode);
        let body=new Catch(...values);
        fetchData().put(body,id).catch(console.error);
        load();
    }

    function deleteCatch(btn) {
        let id=btn.parentNode.getAttribute('data-id');
        fetchData().del(id).then(load).catch(console.error)
    }

    function createCatch() {
        let values=getInfo(getDomElements().$catchForm());
        let body=new Catch(...values);
        fetchData().post(body).then(load).catch(console.error);
    }
    function load() {
        fetchData().get()
            .then(fetchData.handleErrors)
            .then(extractData)
    }

    function extractData(data) {
        getDomElements().$mainDiv().innerHTML='';
       if (data) Object.keys(data).forEach((k)=>fillInfo(k,data[k]));
    }

    function fillInfo(id,object) {

        let newElement=template.cloneNode(true);
        newElement.setAttribute('data-id',id);
        Array.from(newElement.children)
            .forEach(e=>{if (e.tagName==='INPUT') e.value=object[e.className]});
        getDomElements().$mainDiv().appendChild(newElement);
    }
}

attachEvents();

