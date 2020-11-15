import math

t = int(input())
for i in range(1, t + 1):
    l, r = input().split(' ')
    ll = len(l)
    rr = len(r) 
    res1, res2 = 0, 0

    #   left part
    flag = 1
    for j in range(ll):
        t = int(l[j])
        if flag:
            if(j % 2): res1 += int((t + 1) / 2) * (5 ** (ll - j - 1))
            else: res1 += int(t / 2) * (5 ** (ll - j - 1))
        if (t % 2) == (j % 2): flag = 0
        res1 += (5 ** (ll - j - 1))
    if flag and (t % 2) != (j % 2): res1 += 1


    #   right part

    flag = 1
    for j in range(rr):
        t = int(r[j])
        if flag:
            if(j % 2): res2 += int((t + 1) / 2) * (5 ** (rr - j - 1))
            else: res2 += int(t / 2) * (5 ** (rr - j - 1))
        if (t % 2) == (j % 2): flag = 0
        res2 += (5 ** (rr - j - 1))
    if flag and (t % 2) != (j % 2): res2 += 1


    #   result part
    print(res1, res2)
    print("Case #" + str(i) + ": " + str(res2 - res1))