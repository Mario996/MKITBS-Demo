const requestOptions = {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json;charset=UTF-8',
    },
};

async function refreshResults() {
    return fetch(`${process.env.VUE_APP_API_URL}/results/refresh`, requestOptions)
        .then(response => response.json())
        .then(data => data,
            (error) => {
                Promise.reject(error);
            });
}

async function getAllResults() {
    return fetch(`${process.env.VUE_APP_API_URL}/results`, requestOptions)
        .then(response => response.json())
        .then(data => data,
            (error) => {
                Promise.reject(error);
            });
}

export const resultsService = {
    refreshResults,
    getAllResults
};
