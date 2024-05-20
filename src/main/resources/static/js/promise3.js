const $ = (id) => document.getElementById(id);

document.addEventListener("DOMContentLoaded", () => {

    // 同步
    $('queryButton').addEventListener('click', async(event) => {
        console.log('begin');
        const response = await fetch('http://localhost:8081/data/lotto');
        const { state, message, data } = await response.json()
        console.log(state, message, data);

        // 做其他事情
        console.log('do something~~')
        console.log('end');
    })
})