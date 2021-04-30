//GET URL PARAMETER

function getJobId() {
    const url = window.location.href;
    const urlArray = url.split('/');
    const id = urlArray[urlArray.length - 1];
    return id;
}



const loadData = () => {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', `/api/jobs/${getJobId()}`);
    xhr.responseType = 'json';
    xhr.send();
    xhr.onload = function() {
        if(xhr.status != 200) {
            alert(`Error ${xhr.status}: ${xhr.statusText}`)
        } else {
            displayData(xhr.response);
        }
    }
}


//RENDER THE JOB DETAIL
const displayData = (job) => {
    let jobContainer = document.getElementById('job-container');
    let p = document.createElement('p');
    p.innerText = `${job.id} ${job.title} ${job.description}`;
    jobContainer.append(p);
}



document.addEventListener("DOMContentLoaded", () => {
    loadData();
})