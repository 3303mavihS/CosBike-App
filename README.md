# CosBike-App

This app uses android webview to show the cosbike website. I worked on this website as a web developer at my previous company. This app is for educational purposes only.

## Environment Setup

1. Copy `.env.example` to `.env`:
   ```bash
   cp .env.example .env
   ```
2. Fill in real values in `.env` locally. **Never commit `.env`** — it is excluded via `.gitignore`.

## Security Audit (2026-02-09)

### Scope
- Scanned all tracked files and full git history for leaked secrets (API keys, tokens, passwords, AWS keys, private keys, bearer tokens).
- Checked for `.env` files in working tree and git history.

### Findings
- **No `.env` files found** in the working tree or git history — no leaked secrets to rotate.
- **No hardcoded secrets** found in source code, Gradle files, or resources.
- **Gap fixed**: `.gitignore` did not exclude `.env` files — added `.env` / `.env.*` rules (with `!.env.example` exception).
- **Gap fixed**: No `.env.example` template existed — created one with placeholder values.

### TODO
- [ ] **Rotate any secrets** if an `.env` file is ever introduced with real values (currently none exist — nothing to rotate).
- [ ] **Restrict WebView URL loading**: `MainActivity` reloads any URL inside the WebView via `shouldOverrideUrlLoading` — restrict navigation to the `cosbike.in` domain only.
- [ ] **Review `javaScriptEnabled = true`**: required for the site, but ensure the loaded content is always served over HTTPS from a trusted domain.
- [ ] **Fix `shouldOverrideUrlLoading` override**: current code overrides the deprecated `String?` signature instead of the `WebResourceRequest` variant, so URL handling is inconsistent across API levels.
- [ ] **Explicitly set `android:usesCleartextTraffic="false"`** in `AndroidManifest.xml` (currently unset; add a network security config for defense-in-depth).
