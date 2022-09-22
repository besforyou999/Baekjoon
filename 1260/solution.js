/*
const fs = require("fs");
const inputData = fs.readFileSync('/dev/stdin').toString();
*/
const fs = require("fs");
const input = fs.readFileSync('./input.txt').toString().split("\n");
const n_m_v = input[0].split(' ').map((e) => { return parseInt(e) });
N = n_m_v[0], M = n_m_v[1], V = n_m_v[2];

let graph = new Array(N + 1);
for (let i = 0 ; i < N + 1 ; i++) {
    graph[i] = new Array(N + 1);
}

for (let i = 1 ; i <= M ; i++) {
    line = input[i].split(' ').map((e) => { return parseInt(e) });
    start = line[0];
    end = line[1];
    graph[start][end] = 1;
    graph[end][start] = 1;
}

const visited = new Array(N + 1).fill(false);
let result = [];

function dfs(node) {
    if (visited[node]) return;

    visited[node] = true;
    result.push(node)

    for (let i = 0 ; i < N + 1 ; i++) {
        if (visited[i] == false && graph[node][i] == 1) {
            dfs(i);
        }
    }
}

function bfs(node) {
    visited[node] = true;

    queue = []
    queue.push(node);

    while (queue.length > 0) {
        n = queue.shift();
        result.push(n);
        for (let i = 1 ; i < N + 1 ; i++) {
            if (visited[i] == false && graph[n][i] == 1) {
                visited[i] = true;
                queue.push(i);
            }
        }
    }
}

dfs(V);
console.log(result.join(' '));
visited.fill(false);
result = [];
bfs(V);
console.log(result.join(' '));

