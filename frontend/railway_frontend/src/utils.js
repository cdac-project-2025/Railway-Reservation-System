const serverURL = "http://localhost:8081"

export function createURL(path) {
    return `${serverURL}/${path}`
}