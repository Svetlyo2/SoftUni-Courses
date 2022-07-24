import { getDomElements,clearData} from './dom.js';
import { fetchRequest } from './fetch.js';

function attachEvents() {
    const symbols={
        'Sunny':'☀',
        'Partly sunny':	'⛅',
        'Overcast':	 '☁',
        'Rain':	'☂',
        'Degrees': '°',
    };
    getDomElements().$btn().addEventListener('click',main);

    function main(){
        let location=getDomElements().$location().value;
        fetchRequest().locationInfo()
            .then(d=>d.find(o=>o.name===location))
            .then(({code})=>requestCityInfo(code))
            .then(([currentDay,nextDays])=>processInfo(currentDay,nextDays))
            .catch(handleError)
    }
    function requestCityInfo(code){
        return Promise.all([
            fetchRequest().currentDay(code),
            fetchRequest().nextThreeDays(code),
        ])
    }

    function processInfo(currentDay, nextDays){
        getDomElements().$forecast().style.display='block';
        // getDomElements().$current().innerHTML='';
        clearData(getDomElements().$current());
        clearData(getDomElements().$upcoming());
        getCurrentWeather(currentDay);
        getNextDaysWeather(nextDays);
    }
    function getCurrentWeather(currentDay) {
        const {condition, low,high}=currentDay.forecast;
        const symbol=symbols[currentDay.forecast.condition];
        const $divWrapper=createElement('div',['forecasts']);
        const $spanSymbol=createElement('span',['condition','symbol'],symbol);
        const $span=createElement('span',['condition']);
        const $spanName=createElement('span',['forecast-data'],currentDay.name);
        const degreeRange=`${currentDay.forecast.low}/${currentDay.forecast.high}${symbols.Degrees}`;
        const $spanDegree=createElement('span',['forecast-data'], degreeRange);
        const $spanCondition=createElement('span',['forecast-data'],currentDay.forecast.condition);
        $span.append($spanName,$spanDegree,$spanCondition);
        $divWrapper.append($spanSymbol,$span);
        getDomElements().$current().appendChild($divWrapper);
    }
    function getNextDaysWeather(nextDays) {
        const $divWrapper=createElement('div',['forecasts-info']);
        nextDays.forecast.forEach((o)=>{
            const {condition,high,low}=o;
            const symbol=symbols[condition];
            const $span=createElement('span',['upcoming']);
            const $spanSymbol=createElement('span',['symbol'],symbol);
            const degreeRange=`${o.low}/${o.high}${symbols.Degrees}`;
            const $spanDegree=createElement('span',['forecast-data'], degreeRange);
            const $spanCondition=createElement('span',['forecast-data'],o.condition);
            $span.append($spanSymbol,$spanDegree,$spanCondition);
            $divWrapper.appendChild($span);
        });
        getDomElements().$upcoming().appendChild($divWrapper)
    }

    function createElement(tag,classNames, text) {
        let element=document.createElement(tag);
        if (text){element.textContent=text}
        if (classNames){element.classList.add(...classNames)}
        return element
    }
    function handleError() {
        console.log('Invalid input');
        getDomElements().$forecast().style.display='block';
        const error=createElement('div',[],'Error!');
        const errorMsg=createElement('div',[],'Invalid input!');
        clearData(getDomElements().$upcoming());
        getDomElements().$current().innerHTML='';
        getDomElements().$current().appendChild(error);
        getDomElements().$upcoming().appendChild(errorMsg)
    }
}

attachEvents();