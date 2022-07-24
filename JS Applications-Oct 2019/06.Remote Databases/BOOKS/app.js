import {get,getBook,post,put,del} from './requester.js'

const html= {
    'getAllBooks': () => document.getElementById('all-books'),
    'getTitle': () => document.getElementById('title'),
    'getAuthor': () => document.getElementById('author'),
    'getIsbn': () => document.getElementById('isbn'),
    'getEditedTitle': () => document.getElementById('edit-title'),
    'getEditedAuthor': () => document.getElementById('edit-author'),
    'getEditedIsbn': () => document.getElementById('edit-isbn'),
    'editedId':()=>document.getElementById('edit-id'),
};
const actions={
    'load-books': async function(){
        try {
            const books=await get();
            const booksContainer=html.getAllBooks();
            const fragment=document.createDocumentFragment();
            books.forEach(b=>{
                let tr=createElement('tr');
                let titleTd=createElement('td',b.title);
                let authorTd=createElement('td',b.author);
                let isbnTd=createElement('td',b.isbn);
                let btnTd=createElement('td');
                let editBtn=createElement('button','Edit');
                editBtn.id=b._id;
                editBtn.addEventListener('click',this['edit-book-get']);
                let delBtn=createElement('button','Delete');
                delBtn.id=b._id;
                delBtn.addEventListener('click',this['delete-book']);
                btnTd.append(editBtn,delBtn);
                tr.append(titleTd,authorTd,isbnTd,btnTd);
                fragment.appendChild(tr);
            });
            booksContainer.innerHTML='';
            booksContainer.appendChild(fragment);
        }catch (e) {
            alert(e)
        }
    },
    'edit-book-get': async function(){
        const id=this.id;
        let title=html.getEditedTitle();
        let author=html.getEditedAuthor();
        let isbn=html.getEditedIsbn();
        try {
            const book=await getBook(id);
            title.value=book.title;
            author.value=book.author;
            isbn.value=book.isbn;
            html.editedId.value=id;

        } catch (e) {
            alert(e)
        }

    },
    'edit-book-post': async function(){
        const id=html.editedId.value;
        let title=html.getEditedTitle().value;
        let author=html.getEditedAuthor().value;
        let isbn=html.getEditedIsbn().value;
        const book={title,author,isbn};
        if (title === '' || author === '' || isbn === '') {
            alert('Form must be filled correctly!');
        } else {
            await put(book,id);
            html.getEditedTitle().value='';
            html.getEditedAuthor().value='';
            html.getEditedIsbn().value='';
            this["load-books"]();
            html.editedId.value='';
        }
    },
    'delete-book': async function(){
        if (confirm('Are you sure?')){
            try {
                await del(this.id);
                this["load-books"]();
            } catch (e) {
                alert(e)
            }
        }

    },
    'create-book': async function(){
        let title=html.getTitle().value;
        let author=html.getAuthor().value;
        let isbn=html.getIsbn().value;
        if (title === '' || author === '' || isbn === '') {
            alert('Form must be filled correctly!');
        }
        else {
            const data={title,author,isbn};
            await post(data);
            html.getTitle().value='';
            html.getAuthor().value='';
            html.getIsbn().value='';
            this["load-books"]();
        }
    },
};
function createElement(tag,text) {
    let element=document.createElement(tag);
    element.textContent=text;
    return element;
}

function handleEvent(e) {
    if (typeof actions[e.target.id]==='function'){
        e.preventDefault();
        actions[e.target.id]();
    }
}

(function attachEvents() {
    document.addEventListener('click',handleEvent)
}());