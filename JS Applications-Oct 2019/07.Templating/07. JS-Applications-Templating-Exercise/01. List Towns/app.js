function solve() {
    document.getElementById('btnLoadTowns').addEventListener('click', main);

    async function main() {
        const towns = document.getElementById('towns').value.split(', ');
        const source = await fetch('http://localhost:63342/07.%20JS-Applications-Templating-Exercise/01.%20List%20Towns/template.hbs')
            .then(res => res.text());
        const template = Handlebars.compile(source);
        const html = template({towns});
        const container = document.getElementById('root');
        container.innerHTML = html;
    }
}

    solve();
