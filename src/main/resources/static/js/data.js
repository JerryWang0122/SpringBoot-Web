// 透過 $(id) 來替代 document.getElementById(id)
const $ = (id) => document.getElementById(id);

const renderShipTable = (ships) => {
    const rows = ships.map(ship => `<tr>
                                        <td>${ ship.name }</td>
                                        <td>${ ship.type }</td>
                                        <td>${ ship.length }</td>
                                        <td>${ ship.width }</td>
                                    </tr>`).join('');
    const table =`
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Length</th>
                    <th>Width</th>
                </tr>
            </thead>
            <tbody>
                ${rows}
            </tbody>
        </table>`;
    $('result').innerHTML = table;
}

// 待 DOM 加載完成之後再執行
document.addEventListener('DOMContentLoaded', async() => {
    // 監聽 xxxbutton 是否有被點擊
    $('todayBtn').addEventListener("click", async(event) => {
        const response = await fetch('http://localhost:8081/data/today');
        const { state, message, data } = await response.json();
        console.log(data);
        $('result').innerHTML = data;
    });

    $('lottoBtn').addEventListener("click", async(event) => {
        const response = await fetch('http://localhost:8081/data/lotto');
        const { state, message, data } = await response.json();
        console.log(data);
        $('result').innerHTML = data;
    });

    $('shipBtn').addEventListener("click", async(event) => {
        const response = await fetch('http://localhost:8081/data/ship');
        const { state, message, data } = await response.json();
        console.log(data);
        $('result').innerHTML = `name: ${ data.name }<br>
                                 type: ${ data.type }<br>
                                 length: ${ data.length }m<br>
                                 width: ${ data.width }m`;
    });

    $('shipByIdBtn').addEventListener("click", async(event) => {
        const id = window.prompt('請輸入id')
        const response = await fetch(`http://localhost:8081/data/ship/${ id }`);
        const { state, message, data } = await response.json();
        console.log(data);
        if (state) {
            $('result').innerHTML = `name: ${ data.name }<br>
                                 type: ${ data.type }<br>
                                 length: ${ data.length }m<br>
                                 width: ${ data.width }m`;
        } else {
            $('result').innerHTML = message;
        }
    });

    $('shipsBtn').addEventListener("click", async(event) => {
        const response = await fetch('http://localhost:8081/data/ships');
        const { state, message, data } = await response.json();
        // console.log(data);
        // 利用 HTML Table 將資料顯示出來
        renderShipTable(data);
    });
})