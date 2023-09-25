import sys
input = sys.stdin.readline

N = int(input())
books = {}
cnt = -1

for _ in range(N):
    title = input().strip()
    if title in books:
        books[title] += 1
    else:
        books[title] = 1
    cnt = max(cnt, books[title])

best_books = []

for book in books:
    if cnt == books[book]:
        best_books.append(book)

best_books.sort()
print(best_books[0])