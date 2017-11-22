import glob
import matplotlib.pyplot as plt
from csv import reader

for filename in glob.glob("*.csv"):
    n = []
    best_case = []
    worst_case = []

    with open(filename, 'r') as fh:
        next(fh)

        for line in fh:
            data = line.strip().split(",")
            
            n.append(int(data[0]))
            best_case.append(int(data[1]))
            worst_case.append(int(data[2]))

    names = filename.split("_")
    structure = names[0]
    test = names[1]

    print (structure)
    print(test)
    print("Structure " + structure + " " + test)
    #print(n)
    #print(best_case)
    #print(worst_case)

    plt.figure(1, figsize=(7,8))
    plt.subplot(211)
    plt.plot(n, best_case)
    plt.title("Structure " + structure + " Test " + test + " Best Case")
    plt.ylabel("Time Complexity")

    plt.subplot(212)
    plt.plot(n, worst_case)
    plt.title("Structure " + structure + " Test " + test + " Worst Case")
    plt.xlabel("n")
    plt.ylabel("Time Complexitye")

    plt.savefig(structure + "_" + test + ".png", dpi=300)
    plt.close()
