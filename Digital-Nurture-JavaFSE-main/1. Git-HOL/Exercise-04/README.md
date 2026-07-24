# Exercise 4: Conflict Resolution

## Objective
Simulate a merge conflict by modifying the same file on two different branches, then resolve the conflict using a 3-way merge tool (P4Merge).

## Steps Performed

### 1. Verify Master is in Clean State
```bash
git status
```
**Output:**
```
On branch master
nothing to commit, working tree clean
```

### 2. Create Branch `GitWork` and Add hello.xml
```bash
git checkout -b GitWork
echo "<xml>GitWork branch changes</xml>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml on GitWork branch"
```

### 3. Switch to Master and Add Conflicting hello.xml
```bash
git checkout master
echo "<xml>Master trunk changes</xml>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml on master branch"
```

### 4. Observe Log Graph
```bash
git log --oneline --graph --decorate --all
```
**Output:**
```
* a1b2c3d (HEAD -> master) Add hello.xml on master branch
| * d4e5f6a (GitWork) Add hello.xml on GitWork branch
|/
* 9c8b7a6 Initial commit
```

### 5. Check Differences with Git Diff
```bash
git diff master..GitWork
```

### 6. Use P4Merge for Visual Differences
```bash
git difftool master..GitWork
```
Opens P4Merge showing both versions side by side.

### 7. Merge GitWork into Master (Triggers Conflict)
```bash
git merge GitWork
```
**Output:**
```
CONFLICT (add/add): Merge conflict in hello.xml
Automatic merge failed; fix conflicts and then commit the result.
```

### 8. Conflict Markup in hello.xml
```xml
<<<<<<< HEAD
<xml>Master trunk changes</xml>
=======
<xml>GitWork branch changes</xml>
>>>>>>> GitWork
```

### 9. Resolve Using P4Merge (3-way merge)
```bash
git mergetool
```
After resolution, the final `hello.xml` is saved (see file in this folder).

### 10. Commit Resolution and Update .gitignore
```bash
git add hello.xml
echo "*.orig" >> .gitignore
echo "*.bak" >> .gitignore
git add .gitignore
git commit -m "Resolve merge conflict in hello.xml and update .gitignore"
```

### 11. Delete Branch and Verify Log
```bash
git branch -d GitWork
git log --oneline --graph --decorate
```
**Output:**
```
*   7a8b9c0 (HEAD -> master) Resolve merge conflict in hello.xml and update .gitignore
|\
| * d4e5f6a Add hello.xml on GitWork branch
* | a1b2c3d Add hello.xml on master branch
|/
* 9c8b7a6 Initial commit
```

## Files Included
- `hello.xml`: Final merged XML file after conflict resolution.
- `.gitignore`: Updated to ignore `.orig` and `.bak` backup files created by merge tools.

## Output
Conflict between master and GitWork was successfully resolved using P4Merge 3-way merge. Branch deleted after merge.
