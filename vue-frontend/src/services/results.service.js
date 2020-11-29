const requestOptions = {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json;charset=UTF-8',
    },
};

async function refreshResults() {
    return fetch(`${process.env.VUE_APP_API_URL}/results/refresh`, requestOptions)
        .then((response) => {
            if (!response.ok) {
                throw Error(response.statusText);
            }
            return response.json();
        }).then(response => response,
        ).catch((error) => {
            console.log(error);
        });
}

async function getAllResults() {
    return fetch(`${process.env.VUE_APP_API_URL}/results`, requestOptions)
        .then((response) => {
            if (!response.ok) {
                throw Error(response.statusText);
            }
            return response.json();
        }).then(response => response,
        ).catch((error) => {
            console.log(error);
        });
}

async function filterAllResults(plant, storageLocation, materialGroupId) {
    return fetch(`${process.env.VUE_APP_API_URL}/results/filter?filterValue=${createFilter(plant, storageLocation, materialGroupId)}`, requestOptions)
        .then((response) => {
            if (!response.ok) {
                throw Error(response.statusText);
            }
            return response.json();
        }).then(response => response,
        ).catch((error) => {
            console.log(error);
        });
}

function createFilter(plant, storageLocation, materialGroupId) {
    let filter = "$filter=";
    if(plant !== "" && storageLocation === "" && materialGroupId === ""){ 
        filter += "Plant eq '" + plant + "'";
    }
    else if(plant === "" && storageLocation !== "" && materialGroupId === ""){ 
        filter += "StorageLocation eq '" + storageLocation + "'";
    }
    else if(plant === "" && storageLocation === "" && materialGroupId !== ""){ 
        filter += "MaterialGroupId eq '" + materialGroupId + "'";
    }
    else if(plant !== "" && storageLocation !== "" && materialGroupId === ""){
        filter += "Plant eq '" + plant + "'" + " and " + "StorageLocation eq '" + storageLocation + "'";
    }
    else if(plant !== "" && storageLocation === "" && materialGroupId !== ""){
        filter += "Plant eq '" + plant + "'" + " and " + "MaterialGroupId eq '" + materialGroupId + "'";
    }
    else if(plant === "" && storageLocation !== "" && materialGroupId !== ""){
        filter += "StorageLocation eq '" + storageLocation + "'" + " and " + "MaterialGroupId eq '" + materialGroupId + "'";
    }
    else if(plant !== "" && storageLocation !== "" && materialGroupId !== ""){
        filter += "Plant eq '" + plant + "'" + " and " + "StorageLocation eq '" + storageLocation + "'" + " and " + "MaterialGroupId eq '" + materialGroupId + "'";
    }
    else if(plant === "" && storageLocation === "" && materialGroupId === ""){
        filter = "";
    }
    return filter;
}

export const resultsService = {
    refreshResults,
    getAllResults,
    filterAllResults
};
