# Exercise 5: Clean Up and Push to Remote Git

## Objective
Clean up the local repository and push changes back to the remote Git repository.

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

### 2. List All Available Branches
```bash
git branch -a
```
**Output:**
```
* master
```

### 3. Pull Remote Repository to Master
```bash
git pull origin master
```
Pulls latest changes from the remote GitLab repository to local master.

### 4. Push Pending Changes to Remote Repository
```bash
git push origin master
```
Pushes all committed local changes to the remote repository.

### 5. Verify Changes in Remote Repository
```bash
git log --oneline
git status
```

## Files Included
- `commands.txt`: All Git commands executed in this exercise.

## Output
Clean up completed. Local changes pushed to remote Git repository and verified.
