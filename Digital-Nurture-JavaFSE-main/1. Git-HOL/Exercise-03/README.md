# Exercise 3: Branching and Merging

## Objective
Create a new branch, add files, commit changes, merge with master, and delete the branch.

## Steps Performed

### Part A: Branching

#### 1. Create a New Branch
```bash
git branch GitNewBranch
```

#### 2. List All Branches
```bash
git branch -a
```
**Output:**
```
* master
  GitNewBranch
```

#### 3. Switch to the New Branch
```bash
git checkout GitNewBranch
```

#### 4. Add Files on the New Branch
```bash
echo "Welcome to Git!" > welcome.txt
git add welcome.txt
```

#### 5. Commit Changes on the Branch
```bash
git commit -m "Added welcome.txt on GitNewBranch"
```

#### 6. Check Status
```bash
git status
```

### Part B: Merging

#### 7. Switch Back to Master
```bash
git checkout master
```

#### 8. Check Differences Between master and GitNewBranch
```bash
git diff master..GitNewBranch
```

#### 9. View Visual Differences Using P4Merge
```bash
git difftool master..GitNewBranch
```

#### 10. Merge the Branch into Master
```bash
git merge GitNewBranch
```

#### 11. Inspect Commit Log
```bash
git log --oneline --graph --decorate
```

#### 12. Delete the Merged Branch
```bash
git branch -d GitNewBranch
```

## Files Included
- `welcome.txt`: Sample file created on `GitNewBranch` to demonstrate branching.
- `commands.txt`: All Git commands executed in this exercise.

## Output
A new branch was created, a file was added and committed, merged into master, and the branch was deleted.
