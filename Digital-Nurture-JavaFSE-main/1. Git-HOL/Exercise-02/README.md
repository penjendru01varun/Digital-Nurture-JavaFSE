# Exercise 2: Git Ignore

## Objective
Configure `.gitignore` to exclude unwanted files (`.log` extensions and `log/` folders) from being tracked by Git.

## Steps Performed

### 1. Create Unwanted Files and Folders
```bash
# Create a .log file
echo "Application started" > app.log

# Create a log folder with a log file inside
mkdir log
echo "debug info" > log/debug.log
```

### 2. Check Git Status (Before .gitignore)
```bash
git status
```
**Output:**
```
Untracked files:
  app.log
  log/
```
Both files are tracked — we need to ignore them.

### 3. Create .gitignore
```bash
echo "*.log" > .gitignore
echo "log/" >> .gitignore
```

The `.gitignore` file in this folder ignores:
- All files with `.log` extension
- The `log/` directory

### 4. Verify Status After .gitignore
```bash
git status
```
**Output:**
```
Untracked files:
  .gitignore

nothing added to commit (app.log and log/ are now ignored)
```

### 5. Commit .gitignore
```bash
git add .gitignore
git commit -m "Add .gitignore to ignore log files and log folders"
```

## Files Included
- `.gitignore`: Ignore rules for log files and directories.

## Output
Log files and folders are no longer tracked by Git.
