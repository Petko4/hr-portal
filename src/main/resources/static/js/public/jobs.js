const jobsContainer = document.getElementById('jobs-container');

function createJobCard (id, title, descriptionPreview) {
    const jobDiv = document.createElement('div');
    jobDiv.className='col';
    
    const cardDiv = document.createElement('div');
    cardDiv.className='card shadow-sm';
    
    const cardBody = document.createElement('div');
    cardBody.className = 'card-body';
    
    const jobTitle = document.createElement('h5');
    jobTitle.className = 'card-title';
    jobTitle.innerText = title;
    
    const jobDescriptionPreview = document.createElement('p');
    jobDescriptionPreview.className = 'card-text';
    jobDescriptionPreview.innerText = descriptionPreview;
    
    const jobButton = document.createElement('a');
    jobButton.className = 'btn btn-sm btn-outline-secondary';
    jobButton.innerText='Detail';
    jobButton.href = `/job/${id}`;
    
    cardBody.append(jobTitle, jobDescriptionPreview, jobButton);
    cardDiv.append(cardBody);
    jobDiv.append(cardDiv);
    return jobDiv;
    
}

const loadData = () => {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', '/api/job-previews');
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

const displayData = (jobs) => {
    let jobsContainer = document.getElementById('jobs-container');
    for(let job of jobs) {
        jobsContainer.append(createJobCard(job.id, job.title, job.descriptionPreview));
    }
    
}

document.addEventListener("DOMContentLoaded", () => {
    loadData();
})