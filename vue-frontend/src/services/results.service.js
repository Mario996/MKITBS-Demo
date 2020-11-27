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

export const resultsService = {
    refreshResults,
    getAllResults
};
